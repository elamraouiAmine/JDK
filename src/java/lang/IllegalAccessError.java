/*
 * @(#)IllegalAccessError.java	1.9 98/07/01
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

package java.lang;

/**
 * Thrown if an application attempts to access or modify a field, or 
 * to call a method that it does not have access to. 
 * <p>
 * Normally, this error is caught by the compiler; this error can 
 * only occur at run time if the definition of a class has 
 * incompatibly changed. 
 *
 * @author  unascribed
 * @version 1.9, 07/01/98
 * @since   JDK1.0
 */
public class IllegalAccessError extends IncompatibleClassChangeError {
    /**
     * Constructs an <code>IllegalAccessError</code> with no detail message.
     *
     * @since   JDK1.0
     */
    public IllegalAccessError() {
	super();
    }

    /**
     * Constructs an <code>IllegalAccessError</code> with the specified 
     * detail message. 
     *
     * @param   s   the detail message.
     * @since   JDK1.0
     */
    public IllegalAccessError(String s) {
	super(s);
    }
}
