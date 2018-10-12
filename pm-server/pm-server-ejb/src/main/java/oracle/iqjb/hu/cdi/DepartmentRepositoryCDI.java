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
    
    public void deleteByName(String deptname) {
        List<Department> dl = getEntityManager().createQuery("select dept from Department dept where dept.name = :name")
                .setParameter("name", deptname)
                .getResultList();
        
        for (Department d : dl ) {
            getEntityManager().remove(d);
        }
    }
    
    public List<Department> getByName(String deptname) {
        List<Department> dl = getEntityManager().createQuery("select dept from Department dept where dept.name = :name")
                .setParameter("name", deptname)
                .getResultList();
        
        return dl;
    }
    
    public Department getById(Long id) {
        Department d = getEntityManager().find(Department.class, id);
        
        return d;
    }
    
    public Department updateDept(Department dept) {
        Department ret = getEntityManager().merge(dept);
        
        return ret;
    }

    public List<Department> findAll() {
        List<Department> dl = getEntityManager().createQuery("select dept from Department dept", Department.class).getResultList();
        
        return dl;
    }
    
}
