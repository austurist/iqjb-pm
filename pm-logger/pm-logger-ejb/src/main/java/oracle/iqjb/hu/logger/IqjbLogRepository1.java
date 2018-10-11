/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.logger;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author oracle
 */
@Stateless
@LocalBean
public class IqjbLogRepository1 extends IqjbLogRepository {

    @PersistenceContext(unitName = "iqjb1PU")
    private EntityManager em;
    
    @Override
    EntityManager getEntityManager() {
        return em;
    }

 }
