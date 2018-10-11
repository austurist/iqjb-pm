/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import oracle.iqjb.hu.pm.intf.EchoInterface;

/**
 *
 * @author oracle
 */
@Stateless
@Remote(EchoInterface.class)
public class EchoService implements EchoInterface {

    @Override
    public String echo(String arg) {
        return arg;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
