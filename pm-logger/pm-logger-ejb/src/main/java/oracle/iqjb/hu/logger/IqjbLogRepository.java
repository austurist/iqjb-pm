/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.logger;

import javax.persistence.EntityManager;
import oracle.iqjb.hu.pm.dm.IqjbLog;

/**
 *
 * @author oracle
 */
public abstract class IqjbLogRepository {

    abstract EntityManager getEntityManager();    
    
    public void log(IqjbLog entry) {
        getEntityManager().persist(entry);
    }
    
}
