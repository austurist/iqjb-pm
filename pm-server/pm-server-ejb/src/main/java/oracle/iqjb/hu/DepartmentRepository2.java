/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import oracle.iqjb.hu.pm.dm.Department;

/**
 *
 * @author oracle
 */
@Stateless
@LocalBean
public class DepartmentRepository2 extends DepartmentRepository {

    @PersistenceContext(unitName = "iqjb2PU")
    private EntityManager em;
    
    @Override
    EntityManager getEntityManager() {
        return em;
    }

}
