/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.cdi;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import oracle.iqjb.hu.pm.dm.Department;
import oracle.iqjb.hu.pm.intf.AddDepartmentRequest;
import oracle.iqjb.hu.pm.intf.AddDepartmentResponseEnum;
import oracle.iqjb.hu.pm.intf.DepartmentSessionService;

/**
 *
 * @author oracle
 */
@Named
@Transactional(Transactional.TxType.REQUIRED)
public class DepartmentSessionServiceCDIBean implements DepartmentSessionService {

    @Inject @IqjbDb1
    DepartmentRepositoryCDI d1;

    @Inject @IqjbDb2
    DepartmentRepositoryCDI d2;

    /*
    @EJB(lookup = "iqjbLogServiceBean#oracle.iqjb.hu.pm.intf.IqjbLogService")
    IqjbLogService iqjbLogServiceBean;
    */

    @Override
    //@Interceptors(LoggerInterceptor.class)
    public AddDepartmentResponseEnum addDepartment(AddDepartmentRequest dr) {
        if (dr.getDept() != null && !dr.getDept().isEmpty()) {
            Department dept = new Department(dr.getDept());
            d1.add(dept);
            d2.add(dept);

            return AddDepartmentResponseEnum.SUCCESS;

        } else {
            return AddDepartmentResponseEnum.FAILURE;
        }
    }
    
    public Department createDepartment(AddDepartmentRequest dr) {
        if (dr.getDept() != null && !dr.getDept().isEmpty()) {
            Department dept = new Department(dr.getDept());
            Department cd1 = d1.add(dept);
            //Department cd2 = d2.add(dept);

            return cd1;

        } else {
            return null;
        }
    }

    public AddDepartmentResponseEnum addDepartmentCDI(String dept) {
        return addDepartment(new AddDepartmentRequest(dept));
    }

    public Department createDepartmentCDI(String dept) {
        return createDepartment(new AddDepartmentRequest(dept));
    }
            
    public void delDepartmentCDI(String deptname) {
        d1.deleteByName(deptname);
        d2.deleteByName(deptname);
    }
    
    public List<Department> getDepartmentCDI(String dept) {
        List<Department> dl = new ArrayList<>();
        
        dl.addAll(d1.getByName(dept));
        dl.addAll(d2.getByName(dept));
        
        return dl;
    }
    
    public List<Department> updateByIdCDI(Long id, Department dept) {
        List<Department> dl = new ArrayList<>();
        dept.setId(id);
        dl.add(d1.updateDept(dept));
        dl.add(d2.updateDept(dept));
        
        return dl;
    }

}
