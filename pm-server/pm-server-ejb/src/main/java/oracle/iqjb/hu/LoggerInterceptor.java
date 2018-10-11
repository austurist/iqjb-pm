/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import oracle.iqjb.hu.pm.intf.IqjbLogService;
import oracle.iqjb.hu.pm.intf.LogException;

/**
 *
 * @author oracle
 */
public class LoggerInterceptor {
    
    @EJB(lookup = "iqjbLogServiceBean#oracle.iqjb.hu.pm.intf.IqjbLogService")
    IqjbLogService iqjbLogServiceBean;
    
    
    
    @AroundInvoke
    public Object logMethod(InvocationContext ctx) throws Exception {
        
        try {
            iqjbLogServiceBean.create(String.format("%s:%s", ctx.getMethod().getDeclaringClass().getName(), ctx.getMethod().getName()));
        } catch (LogException ex) {
            Logger.getLogger(LoggerInterceptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ctx.proceed();
    }

    private IqjbLogService lookupIqjbLogServiceBeanRemote() {
        try {
            Context c = new InitialContext();
            return (IqjbLogService) c.lookup("java:global/oracle.iqjb.hu_pm-logger-ear_ear_1.0-SNAPSHOT/oracle.iqjb.hu_pm-logger-ejb_ejb_1.0-SNAPSHOT/IqjbLogServiceBean!oracle.iqjb.hu.pm.intf.IqjbLogService");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
