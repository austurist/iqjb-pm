/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.Remote;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.interceptor.Interceptors;
import oracle.iqjb.hu.pm.dm.Department;
import oracle.iqjb.hu.pm.intf.AddDepartmentRequest;
import oracle.iqjb.hu.pm.intf.AddDepartmentResponseEnum;
import oracle.iqjb.hu.pm.intf.DepartmentSessionService;
import oracle.iqjb.hu.pm.intf.IqjbLogService;
import oracle.iqjb.hu.pm.intf.LogException;

/**
 *
 * @author oracle
 */
@Stateless(mappedName = "departmentSessionServiceBean")
@Remote(DepartmentSessionService.class)
public class DepartmentSessionServiceBean implements DepartmentSessionService {

    @EJB
    DepartmentRepository1 d1;

    @EJB
    DepartmentRepository2 d2;

    @EJB(lookup = "iqjbLogServiceBean#oracle.iqjb.hu.pm.intf.IqjbLogService")
    IqjbLogService iqjbLogServiceBean;

    @Resource
    private TimerService timerservice;

    @Override
    @Interceptors(LoggerInterceptor.class)
    public AddDepartmentResponseEnum addDepartment(AddDepartmentRequest dr) {
        if (dr.getDept() != null && !dr.getDept().isEmpty()) {
            Department dept = new Department(dr.getDept());
            d1.add(dept);
            d2.add(dept);

            timerservice.createTimer(5000, "yeah, done.");

            return AddDepartmentResponseEnum.SUCCESS;

        } else {
            return AddDepartmentResponseEnum.FAILURE;
        }
    }

    @Timeout
    private void timeout(Timer timer) throws LogException {
        iqjbLogServiceBean.create(timer.getInfo().toString());
    }

}
