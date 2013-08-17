/*
 * @(#)ChoicePeer.java	1.8 98/07/01
 *
 * Copyright 1995-1998 by Sun Microsystems, Inc.,
 * 901 San Antonio Road, Palo Alto, California, 94303, U.S.A.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of Sun Microsystems, Inc. ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Sun.
 */
package java.awt.peer;

import java.awt.*;     

public interface ChoicePeer extends ComponentPeer {
    void add(String item, int index);
    void remove(int index);
    void select(int index);

    /*
     * DEPRECATED:  Replaced by add(String, int).
     */
    void addItem(String item, int index);
}
