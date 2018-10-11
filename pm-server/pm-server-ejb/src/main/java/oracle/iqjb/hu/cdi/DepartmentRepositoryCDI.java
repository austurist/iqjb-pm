/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.cdi;

import java.util.List;
import javax.persistence.EntityManager;
import oracle.iqjb.hu.pm.dm.Department;

/**
 *
 * @author oracle
 */
public abstract class DepartmentRepositoryCDI {
    
    abstract EntityManager getEntityManager();
    
    public Department add(Department dept) {
        getEntityManager().persist(dept);
        return dept;
    }
    
    public List<Department> findAll() {
        List<Department> dl = getEntityManager().createQuery("select dept from Department dept", Department.class).getResultList();
        
        return dl;
    }
    
}
