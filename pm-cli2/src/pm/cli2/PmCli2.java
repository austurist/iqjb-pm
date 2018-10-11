/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm.cli2;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import oracle.iqjb.hu.pm.intf.AddDepartmentRequest;
import oracle.iqjb.hu.pm.intf.DepartmentSessionService;

/**
 *
 * @author oracle
 */
public class PmCli2 {

    public static void main(String[] args) {
        String jndiPath = "departmentSessionServiceBean#oracle.iqjb.hu.pm.intf.DepartmentSessionService";
        
        //String jndiPath = "java:global/oracle.iqjb.hu_pm-server-ear_ear_1.0-SNAPSHOT/pm-server-ejb-1.0-SNAPSHOT/DepartmentSessionServiceBean";
                
        try {
            final Context ctx = getInitialContext();
            System.out.format("%s%n", "standaloneapp.main: looking up bean at:" + jndiPath);
            DepartmentSessionService dsbean = (DepartmentSessionService) ctx.lookup(jndiPath);
            System.out.format("%s%n", dsbean.addDepartment(new AddDepartmentRequest("Pokoli osztály 2")));
            //dsbean.addDepartment(new AddDepartmentRequest("Foo"));
        } catch (Exception e) {
            System.err.println("Could not find something" + e.getMessage());
            e.printStackTrace();
        }
    }

    private static InitialContext getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://localhost:7001");
        return new InitialContext(env);
    }
    
}
