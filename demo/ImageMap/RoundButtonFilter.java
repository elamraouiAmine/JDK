/*
 * @(#)RoundButtonFilter.java	1.8 98/03/18
 *
 * Copyright (c) 1995-1997 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Sun grants you ("Licensee") a non-exclusive, royalty free, license to use,
 * modify and redistribute this software in source and binary code form,
 * provided that i) this copyright notice and license appear on all copies of
 * the software; and ii) Licensee does not utilize the software in a manner
 * which is disparaging to Sun.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING ANY
 * IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR
 * NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE
 * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
 * OR DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR ITS
 * LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT,
 * INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER
 * CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF THE USE OF
 * OR INABILITY TO USE SOFTWARE, EVEN IF SUN HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGES.
 *
 * This software is not designed or intended for use in on-line control of
 * aircraft, air traffic, aircraft navigation or aircraft communications; or in
 * the design, construction, operation or maintenance of any nuclear
 * facility. Licensee represents and warrants that it will not use or
 * redistribute the Software for such purposes.
 */

/**
 * An extensible ImageMap applet class.
 * The active areas on the image are controlled by ImageArea classes
 * that can be dynamically loaded over the net.
 *
 * @author 	Jim Graham
 * @version 	1.8, 03/18/98
 */
class RoundButtonFilter extends ButtonFilter {
    int Xcenter;
    int Ycenter;
    int Yradsq;
    int innerW;
    int innerH;
    int Yrad2sq;

    public RoundButtonFilter(boolean press, int p, int b, int w, int h) {
	super(press, p, b, w, h);
	Xcenter = w/2;
	Ycenter = h/2;
	Yradsq = h * h / 4;
	innerW = w - border * 2;
	innerH = h - border * 2;
	Yrad2sq = innerH * innerH / 4;
    }

    public boolean inside(int x, int y) {
	int yrel = Math.abs(Ycenter - y);
	int xrel = (int) (Math.sqrt(Yradsq - yrel * yrel) * width / height);
	return (x >= Xcenter - xrel && x < Xcenter + xrel);
    }

    public void buttonRanges(int y, int ranges[]) {
	int yrel = Math.abs(Ycenter - y);
	int xrel = (int) (Math.sqrt(Yradsq - yrel * yrel) * width / height);
	ranges[0] = 0;
	ranges[1] = Xcenter - xrel;
	ranges[6] = Xcenter + xrel;
	ranges[7] = width;
	ranges[8] = ranges[9] = y;
	if (y < border) {
	    ranges[2] = ranges[3] = ranges[4] = Xcenter;
	    ranges[5] = ranges[6];
	} else if (y + border >= height) {
	    ranges[2] = ranges[1];
	    ranges[3] = ranges[4] = ranges[5] = Xcenter;
	} else {
	    int xrel2 = (int) (Math.sqrt(Yrad2sq - yrel * yrel)
			       * innerW / innerH);
	    ranges[3] = Xcenter - xrel2;
	    ranges[4] = Xcenter + xrel2;
	    if (y < Ycenter) {
		ranges[2] = ranges[3];
		ranges[5] = ranges[6];
	    } else {
		ranges[2] = ranges[1];
		ranges[5] = ranges[4];
	    }
	}
    }

    public int filterRGB(int x, int y, int rgb) {
	boolean brighter;
	int percent;
	int i;
	int xrel, yrel;
	int ranges[] = getRanges(y);
	for (i = 0; i < 7; i++) {
	    if (x >= ranges[i] && x < ranges[i+1]) {
		break;
	    }
	}
	switch (i) {
	default:
	case 0:
	case 6:
	    return rgb & 0x00ffffff;
	case 1:
	    brighter = !pressed;
	    percent = defpercent;
	    break;
	case 5:
	    brighter = pressed;
	    percent = defpercent;
	    break;
	case 2:
	    yrel = y - Ycenter;
	    xrel = Xcenter - x;
	    percent = (int) (yrel * defpercent * 2 /
			     Math.sqrt(yrel * yrel + xrel * xrel))
		- defpercent;
	    if (!pressed) {
		percent = -percent;
	    }
	    if (percent == 0) {
		return rgb;
	    } else if (percent < 0) {
		percent = -percent;
		brighter = false;
	    } else {
		brighter = true;
	    }
	    break;
	case 4:
	    yrel = Ycenter - y;
	    xrel = x - Xcenter;
	    percent = (int) (yrel * defpercent * 2 /
			     Math.sqrt(yrel * yrel + xrel * xrel))
		- defpercent;
	    if (pressed) {
		percent = -percent;
	    }
	    if (percent == 0) {
		return rgb;
	    } else if (percent < 0) {
		percent = -percent;
		brighter = false;
	    } else {
		brighter = true;
	    }
	    break;
	case 3:
	    if (!pressed) {
		return rgb & 0x00ffffff;
	    }
	    brighter = false;
	    percent = defpercent;
	    break;
	}
	return filterRGB(rgb, brighter, percent);
    }
}
