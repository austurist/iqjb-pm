/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.cdi;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author oracle
 */
public class PersistenceProducer {
    
    @Produces
    @IqjbDb1
    @PersistenceContext(unitName = "iqjb1PU")
    EntityManager em1;
    
    @Produces
    @IqjbDb2
    @PersistenceContext(unitName = "iqjb2PU")
    EntityManager em2;
    
}
