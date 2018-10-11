/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.intf;

import javax.ejb.ApplicationException;

/**
 *
 * @author oracle
 */
@ApplicationException(rollback = false)
public class LogException extends Exception {

    /**
     * Creates a new instance of <code>LogException</code> without detail
     * message.
     */
    public LogException() {
    }

    /**
     * Constructs an instance of <code>LogException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public LogException(String msg) {
        super(msg);
    }
}
