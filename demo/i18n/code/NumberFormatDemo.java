/*
 * @(#)NumberFormatDemo.java	 1.1 98/06/16
 *
 * (C) Copyright Taligent, Inc. 1996 - All Rights Reserved
 * (C) Copyright IBM Corp. 1996 - All Rights Reserved
 *
 * Portions copyright (c) 1996 Sun Microsystems, Inc. All Rights Reserved.
 *
 *   The original version of this source code and documentation is copyrighted
 * and owned by Taligent, Inc., a wholly-owned subsidiary of IBM. These
 * materials are provided under terms of a License Agreement between Taligent
 * and Sun. This technology is protected by multiple US and International
 * patents. This notice and attribution to Taligent may not be removed.
 *   Taligent is a registered trademark of Taligent, Inc.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL purposes and without
 * fee is hereby granted provided that this copyright notice
 * appears in all copies. Please refer to the file "copyright.html"
 * for further important copyright and licensing information.
 *
 * SUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 */

import java.applet.Applet;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.text.*;

/**
 * Concrete class for demonstrating how to convert binary numbers into text
 * strings for meaningful display.
 * The following is the instruction on how to run the number format demo.
 * <p>
 * ===================
 * <P>Number formatters convert binary numbers (integer or float data types)
 * into text strings for meaningful display. The number formatters:
 * <UL>
 * <LI>Provide control over every aspect of the display, including separator
 * characters, optional digits, maximum and minimum decimal and integer places,
 * and optional prefixes and suffixes </LI>
 * <LI>Can produce currency and percentage formats and can be extended to
 * produce other formats </LI>
 * <LI>Allow you to specify new formats with string patterns and can retrieve
 * the normalized pattern </LI>
 * <LI>Can parse anything they can format, for use when converting text input
 * into binary data </LI>
 * </UL>
 * <P><CENTER>
 * <A HREF="#localized">Localized Formats</A> &nbsp;
 * <A HREF="#patterns">Creating Formats with Patterns </A> &nbsp;
 * <A HREF="#parsing">Parsing Text </A>
 * </CENTER></P>
 * <HR>
 * <H3><A NAME="localized">Localized Formats </A></H3>
 * <P>The number formatters let you format numbers in the ways that are
 * appropriate for any user's conventions, including country-specific formats
 * such as currencies.  You can also specify other formatting options such as
 * minimum and maximum number of digits displayed.
 * </P>
 * <P> The applet displays the number in two formats&#151;the Java 1.0
 * representation (&quot;Java 1.0 Number&quot;), and the localized format
 * generated by the number formatters (&quot;New Number&quot;).
 * </P>
 * <TABLE WIDTH=100% CELLPADDING=5>
 * <TR>
 * <TH ALIGN=left VALIGN=bottom>To See This...</TH>
 * <TH ALIGN=left VALIGN=bottom>Do This...</TH>
 * </TR>
 * <TR>
 * <TD WIDTH=50% VALIGN=top> Localized number formats.  In the international
 * string, the separator characters change to reflect the conventions used by
 * different countries.
 * </TD>
 * <TD VALIGN=top>
 * <TABLE CELLSPACING=0 CELLPADDING=0>
 * <TR>
 * <TD WIDTH=10 VALIGN=top> 1.
 * </TD>
 * <TD> Pull down the Locale menu
 * </TD>
 * </TR>
 * <TR>
 * <TD WIDTH=10 VALIGN=top> 2.
 * </TD>
 * <TD> Try several different locales with the up and down arrow keys
 * (on Windows) or the mouse button (on Macintosh)
 * </TD>
 * </TR>
 * </TABLE>
 * </TD>
 * </TR>
 * <TR>
 * <TD WIDTH=50% VALIGN=top> Localized currency formats.  The formatter adds
 * a prefix or suffix to indicate the currency unit.  It also uses a minus sign
 * or parentheses to indicate negative numbers, as appropriate.
 * </TD>
 * <TD VALIGN=top>
 * <TABLE CELLSPACING=0 CELLPADDING=0>
 * <TR>
 * <TD WIDTH=10 VALIGN=top> 1.
 * </TD>
 * <TD> Click on the <I> Currency </I> button
 * </TD>
 * </TR>
 * <TR>
 * <TD WIDTH=10 VALIGN=top> 2.
 * </TD>
 * <TD> Pull down the Locale menu and try several different locales
 * </TD>
 * </TR>
 * </TABLE>
 * </TD>
 * </TR>
 * <TR>
 * <TD WIDTH=50% VALIGN=top> Setting formatting options, for example,
 * specifying a precise  number of decimal places.
 * </TD>
 * <TD VALIGN=top>
 * <TABLE CELLSPACING=0 CELLPADDING=0>
 * <TR>
 * <TD WIDTH=10 VALIGN=top> 1.
 * </TD>
 * <TD> Type &quot;3&quot; in the <I>Min </I> field for <I> Decimal Count </I>
 * &#151;the formatter appends zeroes to display the specified number of
 * decimal places
 * </TD>
 * </TR>
 * </TABLE>
 * </TD>
 * </TR>
 * </TABLE>
 * <HR WIDTH=50% ALIGN=left>
 * <H3><A NAME="patterns">Creating Formats with Patterns </A></H3>
 * <P> A string pattern can control the output format for a number formatter,
 * making it easy for you to edit a format or provide an editing mechanism
 * for end users.  The pattern also changes to reflect any changes you make
 * programmatically.
 * </P>
 * <P> Patterns can either be invariant (for use only by programmers) or
 * localized (for use by end users).  Click on the <I> Localized Pattern </I>
 * box to change the state.
 * <TABLE WIDTH=100% CELLPADDING=5>
 * <TR>
 * <TH ALIGN=left VALIGN=bottom>To See This...</TH>
 * <TH ALIGN=left VALIGN=bottom>Do This...</TH>
 * </TR>
 * <TR>
 * <TD WIDTH=50% VALIGN=top> You can edit the pattern to create a new format.
 * </TD>
 * <TD VALIGN=top>
 * <TABLE CELLSPACING=0 CELLPADDING=0>
 * <TR>
 * <TD WIDTH=10 VALIGN=top> 1.
 * </TD>
 * <TD> Select the <I> Default Format </I> button and the <I>English
 * (United States) </I> locale
 * </TD>
 * </TR>
 * <TR>
 * <TD WIDTH=10 VALIGN=top> 2.
 * </TD>
 * <TD> Increase the maximum number for <I>Decimal Count</I>
 * </TD>
 * </TR>
 * <TR>
 * <TD WIDTH=10 VALIGN=top> 3.
 * </TD>
 * <TD> Delete the &quot;&#35;&quot; characters at the end of the <I>Pattern
 * </I> field and type in zeroes&#151;the decimal places in the <I>New Number
 * </I> field change to zeroes
 * </TD>
 * </TR>
 * </TABLE>
 * </TD>
 * </TR>
 * <TR>
 * <TD WIDTH=50% VALIGN=top> You can edit the prefix and suffix strings, and
 * create different patterns for positive and negative numbers.
 * </TD>
 * <TD VALIGN=top>
 * <TABLE CELLSPACING=0 CELLPADDING=0>
 * <TR>
 * <TD WIDTH=10 VALIGN=top> 1.
 * </TD>
 * <TD> Type a plus sign (&quot;+&quot;) in the <I> Prefix </I> field for
 * positive numbers to modify the positive number pattern
 * </TD>
 * </TR>
 * <TR>
 * <TD WIDTH=10 VALIGN=top> 2.
 * </TD>
 * <TD> Delete the minus sign from the Java 1.0 number
 * </TD>
 * </TR>
 * </TABLE>
 * </TD>
 * </TR>
 * </TABLE>
 * <HR WIDTH=50% ALIGN=left>
 * <H3><A NAME="parsing">Parsing Text </A></H3>
 * <P>The number formatters not only format for any language, but can parse
 * numbers displayed in any language back into binary format.
 * </P>
 * <TABLE WIDTH=100% CELLPADDING=5>
 * <TR>
 * <TH ALIGN=left VALIGN=bottom>To See This...</TH>
 * <TH ALIGN=left VALIGN=bottom>Do This...</TH>
 * </TR>
 * <TR>
 * <TD WIDTH=50% VALIGN=top> Changes to the international number are parsed
 * and reflected in the <I> Java 1.0 Number </I> field.
 * </TD>
 * <TD VALIGN=top>
 * <TABLE CELLSPACING=0 CELLPADDING=0>
 * <TR>
 * <TD WIDTH=10 VALIGN=top> 1.
 * </TD>
 * <TD> Select the thousands separator character in the <I>New Number </I>
 * field (the comma if you are still in the U.S. locale) and replace it with
 * a number
 * </TD>
 * </TR>
 * </TABLE>
 * </TD>
 * </TR>
 * </TABLE>
 * <P>The parsing mechanism is somewhat lenient. For example, a thousands
 * separator character can be misplaced and the parser still returns the
 * correct value. </P>
 * <P>Though not yet demonstrated here, the number formatters also handle
 * IEEE number symbols such as the infinity sign and NaN (for example, 0/0),
 * creating the correct results for both formatting and parsing. The formatters
 * also return the alignment point so you can line up the end of integer
 * portions correctly even without monospace fonts or with strange number
 * conventions. </P>
 * <P>You can type in other numbers in either number field or enter a
 * completely new pattern to  see different formatting behaviors.  Try it out!
 * </P>
 * @see        java.util.Format
 * @see        java.util.NumberFormat
 * @version    1.1 11/23/96
 * @author     Laura Werner, Mark Davis
*/
// Change history:  Helena Shih 091996: Added comments prior spec review.
public class NumberFormatDemo extends DemoApplet
{
    /**
     * The main function which defines the behavior of the NumberFormatDemo
     * applet when an applet is started.
     */
    public static void main(String argv[]) {
        DemoApplet.showDemo(new NumberFormatFrame(null));
    }

    /**
     * This creates a NumberFormatFrame for the demo applet.
     */
    public Frame createDemoFrame(DemoApplet applet) {
        return new NumberFormatFrame(applet);
    }
}

/**
 * A Frame is a top-level window with a title. The default layout for a frame
 * is BorderLayout.  The NumberFormatFrame class defines the window layout of
 * NumberFormatDemo.
 */
class NumberFormatFrame extends Frame implements KeyListener, ItemListener, WindowListener 
{
    /**
     * Constructs a new NumberFormatFrame that is initially invisible.
     */
    public NumberFormatFrame(DemoApplet applet)
    {
        super("Number Formatting Demo");
        this.applet = applet;
	addWindowListener(this);
        init();
        start();
    }

    /**
     * Initializes the applet. You never need to call this directly, it
     * is called automatically by the system once the applet is created.
     */
    public void init()
    {
        //Get all locales for debugging, but only get G7 locales for demos.
        if (DEBUG == true)
             locales = NumberFormat.getAvailableLocales();
        else locales = Utility.getG7Locales();

        buildGUI();

        // Stick the names of the locales into the locale popup menu
        Locale displayLocale = Locale.getDefault();
        for (int i = 0; i < locales.length; i++) {
            if (locales[i].getCountry().length() > 0) {
                localeMenu.addItem( locales[i].getDisplayName() );
                if (locales[i].equals(Locale.getDefault())) {
                    localeMenu.select(i);
                }
            }
        }

        // For starters, use the default format for the selected locale in the
        // menu
        setFormatFromLocale();
    }

    /**
     * Called to start the applet. You never need to call this method
     * directly, it is called when the applet's document is visited.
     */
    public void start()
    {
        inputText.setText("-1234.56");
        clickedRightButton();
    }


  /* ItemListener method */
  public void itemStateChanged(ItemEvent e) {

    if (e.getSource() == getPercent) {
      clickedGetPercent();
    }
    else
    if (e.getSource() == getCurrency) {
      clickedGetCurrency();
    }
    else
    if (e.getSource() == getInstance) {
      clickedGetDefault();
    }
    else
    if (e.getSource() == getLocalized) {
      isLocalized = getLocalized.getState();
      handleNewFormat();
    }
    else
    if (e.getSource() == localeMenu) {
      selectedLocaleMenu();
    }
  }

  /* Key Listener methods */
  public void keyPressed(KeyEvent e) {
  }

  public void keyReleased(KeyEvent e) {
    if (e.getSource() == inputText) {
      inputChanged();
    }
    else
    if (e.getSource() == patternText) {
      patternChanged();
    }
    else
    if (e.getSource() == outputText) {
      outputChanged();
    }
    else
    if (e.getSource() == posSuffix) {
      posSuffixChanged();
    }
    else
    if (e.getSource() == posPrefix) {
      posPrefixChanged();
    }
    else
    if (e.getSource() == negSuffix) {
      negSuffixChanged();
    }
    else
    if (e.getSource() == negPrefix) {
      negPrefixChanged();
    }
    else
    if (e.getSource() == decMax) {
      decMaxChanged();
    }
    else
    if (e.getSource() == decMin) {
      decMinChanged();
    }
    else
    if (e.getSource() == intMax) {
      intMaxChanged();
    }
    else
    if (e.getSource() == intMin) {
      intMinChanged();
    }
  }

  public void keyTyped(KeyEvent e) {
  }

  /* Window Listener methods */
  public void windowClosed(WindowEvent e) {
  }

  public void windowDeiconified(WindowEvent e) {
  }

  public void windowIconified(WindowEvent e) {
  }

  public void windowActivated(WindowEvent e) {
  }

  public void windowDeactivated(WindowEvent e) {
  }

  public void windowOpened(WindowEvent e) {
  }

  public void windowClosing(WindowEvent e) {
    setVisible(false);
    dispose();

    if (applet != null) {
      applet.demoClosed();
    } else System.exit(0);

  }
 
    /**
     * This function is called when it is necessary to create a new number
     * format.  For example, when a new locale is chosen, a new number
     * format for that locale needs to be created.  Or, when a number
     * format attributes have been changed.
     */
    public void handleNewFormat()
    {
        if (isLocalized) {
               workaroundSetText(patternText,format.toLocalizedPattern() );
        } else workaroundSetText(patternText,format.toPattern() );

        // force the text in the output area to use the new format
        clickedRightButton();
    }

    /**
     * A new number format needs to be created if the attributes are changed.
     */
    public void handleAttributeChange()
    {
        handleNewFormat();
    }
    /**
     * Called when a formatting event has occured.
     */
    public boolean handleFormatting(Event evt, Object obj)
    {
        return true;
    }


    /**
     * Create a new number format if a new locale has been selected.
     */
    public void setFormatFromLocale() {
        // Find the locale corresponding to the currently selected menu item
        int index = localeMenu.getSelectedIndex();
        Locale aLocale = locales[index];

        if (getPercent.getState()) {
            format = (DecimalFormat) NumberFormat.getPercentInstance(aLocale);
        } else if (getCurrency.getState()) {
            format = (DecimalFormat) NumberFormat.getCurrencyInstance(aLocale);
        } else {
            format = (DecimalFormat) NumberFormat.getInstance(aLocale);
        }

        handleNewFormat();

        updateAttributes();
    }

    /**
     * This is used to avoid goofy updates and misplaced cursors
     */
    public void workaroundSetText(TextComponent area, String newText) {
        String foo = workaround(area.getText());
        if (foo.equals(newText)) return;
        area.setText(newText);
        //if (area.gotFocus())
        //    area.select(newText.length(),newText.length());
    }

    /**
     * Update the attributes.
     */
    public void updateAttributes() {
        workaroundSetText(intMin,toString(format.getMinimumIntegerDigits()) );
        workaroundSetText(intMax,toString(format.getMaximumIntegerDigits()) );
        workaroundSetText(decMin,toString(format.getMinimumFractionDigits()) );
        workaroundSetText(decMax,toString(format.getMaximumFractionDigits()) );

        workaroundSetText(negPrefix,format.getNegativePrefix() );
        workaroundSetText(negSuffix,format.getNegativeSuffix() );
        workaroundSetText(posPrefix,format.getPositivePrefix() );
        workaroundSetText(posSuffix,format.getPositiveSuffix() );
    }

    /**
     * Get the default number formatter.
     */
    public void clickedGetDefault() {
        setFormatFromLocale();
    }
    /**
     * Update the number formatter with currency attribute.
     */
    public void clickedGetCurrency() {
        setFormatFromLocale();
    }
    /**
     * Update the number formatter with percentage attribute.
     */
    public void clickedGetPercent() {
        setFormatFromLocale();
    }
    /**
     * Update the number formatter when a new locale is selected.
     */
    public void selectedLocaleMenu() {
        setFormatFromLocale();
    }
    /**
     * If the user changes the input number, format it immediately
     */
    public void inputChanged() {
        clickedRightButton();
    }
    /**
     * If the user changes the output number, format it immediately
     */
    public void outputChanged() {
        clickedLeftButton();
    }

    /**
     * Update the text in the input area to use the new number format.
     */
    public void clickedRightButton() {
        String leftString = workaround(inputText.getText());
        Number num;

        try {
            num = new Double(leftString);
        }
        catch (IllegalArgumentException e) {
            outputText.setText("");
            inputText.selectAll();
            return;
        }
        workaroundSetText(outputText,format.format(num));
    }

    /**
     * Update the text in the output area to use the new number format.
     */
    public void clickedLeftButton() {
        String rightString = workaround(outputText.getText());
        Number num;
        ParsePosition status = new ParsePosition(1);

        try {
            num = format.parse(rightString, status);
        }
        catch (IllegalArgumentException e) {
            errorText("Exception: " + e.getClass() + e.getMessage());
            inputText.setText("");
            outputText.selectAll();
            return;
        }
        if (status.getIndex() != rightString.length()) {
            errorText("excess text: " +
                      rightString.substring(status.getIndex(),
                                            rightString.length()));
        }
        workaroundSetText(inputText, num.toString() );
    }

    /**
     * When the user changes the field containing the pattern, a new format
     * needs to be constructed from the pattern, then redisplay everything.
     */
    public void patternChanged() {
        String foo = workaround(patternText.getText());
        try {
            if (isLocalized) {
                   format.applyLocalizedPattern(foo);
                   errorText("Pattern: " + foo + " -> " +
                         format.toLocalizedPattern());
            } else {
               format.applyPattern(foo);
               errorText("Pattern: " + foo + " -> " +
                           format.toPattern());
            }
        } catch (Exception bar) {
            errorText("Exception: " + bar.getClass() + bar.getMessage());
        }
        updateAttributes();
        clickedRightButton();

    }
    //------------------------------------------------------------
    // package private
    //------------------------------------------------------------
    void addWithFont(Container container, Component foo, Font font) {
        if (font != null)
            foo.setFont(font);
        container.add(foo);
    }

    //{{DECLARE_CONTROLS
    Panel localePanel;
    CheckboxGroup group1;
    Label label1;
    Label label2;
    Label label3;
    Choice localeMenu;
    Label localeLabel;
    TextField inputText;
    TextField outputText;
    //Button rightButton;
    //Button leftButton;
    TextField patternText;
    Label label4;
    TextField negPrefix;
    TextField negSuffix;
    TextField posPrefix;
    TextField posSuffix;
    Label label5;
    Label label6;
    Label label7;
    Label label8;
    TextField intMin;
    TextField intMax;
    TextField decMin;
    TextField decMax;
    Label label9;
    Label label10;
    Label label11;
    Label label12;
    Checkbox getInstance;
    Checkbox getCurrency;
    Checkbox getPercent;
    Checkbox getLocalized;
    Label label13;
    Label label14;
    //}}
    //------------------------------------------------------------
    // private
    //------------------------------------------------------------
    private void buildGUI()
    {
        //{{INIT_CONTROLS
        setBackground(Color.white); // MD 8/7
        // shouldn't be necessary, but it is!
        setLayout(new FlowLayout(FlowLayout.CENTER,2,2));

        // INPUT/OUTPUT/PATTERN


        Panel creditPanel = new Panel();
        label1=new Label("Decimal Number Formatting Demo",
                         Label.CENTER);
        label1.setFont(Utility.titleFont);
        creditPanel.add(label1);

        label13=new Label(creditString, Label.CENTER);
        label13.setFont(Utility.creditFont);
        creditPanel.add(label13);
        Utility.fixGrid(creditPanel,1);

        add(creditPanel);

        // IO
        Panel ioPanel = new Panel();

        label3=new Label("New Number", Label.RIGHT);
        label3.setFont(Utility.labelFont);
        ioPanel.add(label3);

        outputText=new TextField(FIELD_COLUMNS);
        outputText.setFont(Utility.editFont);
        ioPanel.add(outputText);

        /*Panel gap1 = new Panel();
        gap1.setLayout(null);
        gap1.resize(5,5);
        gap1.add(outputText);

        Panel gap2 = new Panel();
        gap2.setLayout(null);
        gap2.resize(5,5);
        gap2.add(outputText);
        */

        label2=new Label("Java 1.0 Number", Label.RIGHT);
        label2.setFont(Utility.labelFont);
        ioPanel.add(label2);

        inputText=new TextField(FIELD_COLUMNS);
	inputText.addKeyListener(this);
        inputText.setFont(Utility.editFont);
        ioPanel.add(inputText);

        label4=new Label("Pattern", Label.RIGHT);
        label4.setFont(Utility.labelFont);
        ioPanel.add(label4);

        patternText=new TextField(FIELD_COLUMNS);
	patternText.addKeyListener(this);
        patternText.setFont(Utility.editFont);
        ioPanel.add(patternText);

        ioPanel.add(new Label(" "));

        getLocalized=new Checkbox("Localized Pattern");
	getLocalized.addItemListener(this);
        getLocalized.setFont(Utility.labelFont);
        ioPanel.add(getLocalized);

        Utility.fixGrid(ioPanel,2);
        add(ioPanel);

         // LOCALE

        localePanel=new Panel();

        localeLabel=new Label("Locale:");
        localeLabel.setFont(Utility.labelFont);
        localePanel.add("loc",localeLabel);

        localeMenu= new Choice();
	localeMenu.addItemListener(this);
        localeMenu.setFont(Utility.choiceFont);
        localePanel.add(localeMenu);

        // FORMAT CHECKS

        group1= new CheckboxGroup();

        getInstance=new Checkbox("Default Format",group1, false);
	getInstance.addItemListener(this);
        getInstance.setFont(Utility.labelFont);
        localePanel.add(getInstance);

        getCurrency=new Checkbox("Currency Format",group1, true);
	getCurrency.addItemListener(this);
        getCurrency.setFont(Utility.labelFont);
        localePanel.add(getCurrency);

        getPercent=new Checkbox("Percent Format",group1, false);
	getPercent.addItemListener(this);
        getPercent.setFont(Utility.labelFont);
        localePanel.add(getPercent);

        Utility.fixGrid(localePanel,1);

        Panel bottomPanel = new Panel();

        bottomPanel.add(localePanel);

        BorderPanel x = new BorderPanel();
        x.setBackground(Color.lightGray);
        x.setLayout(null);
        x.setSize(8,130);
        bottomPanel.add(x);

        // PARAMETERS

        Panel parameterPanel = new Panel();

        parameterPanel.add(new Label(" "));

        label11=new Label("Min", Label.CENTER);
        label11.setFont(Utility.labelFont);
        parameterPanel.add(label11);

        label12=new Label("Max", Label.CENTER);
        label12.setFont(Utility.labelFont);
        parameterPanel.add(label12);


        label9=new Label("Integers", Label.RIGHT);
        label9.setFont(Utility.labelFont);
        parameterPanel.add(label9);

        intMin=new TextField(4);
	intMin.addKeyListener(this);
        intMin.setFont(Utility.editFont);
        parameterPanel.add(intMin);

        intMax=new TextField(4);
	intMax.addKeyListener(this);
        intMax.setFont(Utility.editFont);
        parameterPanel.add(intMax);


        label10=new Label("Decimals", Label.RIGHT);
        label10.setFont(Utility.labelFont);
        parameterPanel.add(label10);

        decMin=new TextField(4);
	decMin.addKeyListener(this);
        decMin.setFont(Utility.editFont);
        parameterPanel.add(decMin);

        decMax=new TextField(4);
	decMax.addKeyListener(this);
        decMax.setFont(Utility.editFont);
        parameterPanel.add(decMax);


        parameterPanel.add(new Label(" "));

        label7=new Label("Prefix", Label.CENTER);
        label7.setFont(Utility.labelFont);
        parameterPanel.add(label7);

        label8=new Label("Suffix", Label.CENTER);
        label8.setFont(Utility.labelFont);
        parameterPanel.add(label8);


        label6=new Label("Positive", Label.RIGHT);
        label6.setFont(Utility.labelFont);
        parameterPanel.add(label6);

        posPrefix=new TextField(4);
	posPrefix.addKeyListener(this);
        posPrefix.setFont(Utility.editFont);
        parameterPanel.add(posPrefix);

        posSuffix=new TextField(4);
	posSuffix.addKeyListener(this);
        posSuffix.setFont(Utility.editFont);
        parameterPanel.add(posSuffix);


        label5=new Label("Negative", Label.RIGHT);
        label5.setFont(Utility.labelFont);
        parameterPanel.add(label5);

        negPrefix=new TextField(4);
	negPrefix.addKeyListener(this);
        negPrefix.setFont(Utility.editFont);
        parameterPanel.add(negPrefix);

        negSuffix=new TextField(4);
	negSuffix.addKeyListener(this);
        negSuffix.setFont(Utility.editFont);
        parameterPanel.add(negSuffix);

        Utility.fixGrid(parameterPanel,3);

        bottomPanel.add(parameterPanel);
        Utility.fixGrid(bottomPanel,3);
        Utility.setInsets(bottomPanel,x,new Insets(20,20,2,2));
        add(bottomPanel);

        Panel copyrightPanel = new Panel();
        addWithFont (copyrightPanel,new Label(copyrightString, Label.LEFT),
                     Utility.creditFont);
        addWithFont (copyrightPanel,new Label(copyrightString2, Label.LEFT),
                     Utility.creditFont);
        Utility.fixGrid(copyrightPanel,1);
        add(copyrightPanel);


    }

    private String toString( int anInt )
    {
        Integer intObj = new Integer(anInt);
        return intObj.toString();
    }

    private int parseIntField(TextComponent text) {
        int result = 0;
        try {
            Integer value = new Integer(workaround(text.getText()));
            result = value.intValue();
        }
        catch (NumberFormatException e) {
        }
        return result;
    }

    private void intMinChanged() {
        format.setMinimumIntegerDigits(parseIntField(intMin));
        updateAttributes();
        handleAttributeChange();
    }
    private void intMaxChanged() {
        format.setMaximumIntegerDigits(parseIntField(intMax));
        updateAttributes();
        handleAttributeChange();
    }
    private void decMinChanged() {
        format.setMinimumFractionDigits(parseIntField(decMin));
        updateAttributes();
        handleAttributeChange();
    }
    private void decMaxChanged() {
        format.setMaximumFractionDigits(parseIntField(decMax));
        updateAttributes();
        handleAttributeChange();
    }
    private void negPrefixChanged() {
        format.setNegativePrefix(workaround(negPrefix.getText()));
        updateAttributes();
        handleAttributeChange();
    }
    private void negSuffixChanged() {
        format.setNegativeSuffix(workaround(negSuffix.getText()));
        updateAttributes();
        handleAttributeChange();
    }
    private void posPrefixChanged() {
        format.setPositivePrefix(workaround(posPrefix.getText()));
        updateAttributes();
        handleAttributeChange();
    }
    private void posSuffixChanged() {
        format.setPositiveSuffix(workaround(posSuffix.getText()));
        updateAttributes();
        handleAttributeChange();
    }
    /**
     * Strips high bits, because of bug in Java
     */
    private static String workaround(String source) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < source.length(); ++i)
            result.append((char)(source.charAt(i) & 0xFF));
        return result.toString();
    }

    private void errorText(String s)
    {
        if (DEBUG)
        {
          System.out.println(s);
        }
    }

    private static final String creditString =
        "v1.1a6, Demo:";
    private static final String copyrightString =
        "";
    private static final String copyrightString2 =
        "";
    private static final int FIELD_COLUMNS = 35;

    private static final boolean DEBUG = false;

    private static boolean isLocalized = false;

    // private Choice formatter, locale;

    private DecimalFormat format;
    private Locale[] locales;
    private DemoApplet applet;

}
