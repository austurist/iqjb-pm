/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.cdi;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author oracle
 */
@IqjbDb1
public class DepartmentRepositoryCDI1 extends DepartmentRepositoryCDI {

    @Inject @IqjbDb1
    private EntityManager em;

    @Override
    EntityManager getEntityManager() {
        return em;
    }

}
