/*
 * @(#)ExportException.java	1.3 98/07/01
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

package java.rmi.server;

public class ExportException extends java.rmi.RemoteException {

    /**
     * Create A remote exception with the specified string
     */
    public ExportException(String s) {
	super(s);
    }

    /**
     * Create A remote exception with the specified string, and the
     * exception specified.
     */
    public ExportException(String s, Exception ex) {
	super(s, ex);
    }

}
