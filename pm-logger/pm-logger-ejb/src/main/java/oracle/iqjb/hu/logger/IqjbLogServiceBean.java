/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.logger;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import oracle.iqjb.hu.pm.dm.IqjbLog;
import oracle.iqjb.hu.pm.intf.DepartmentSessionService;
import oracle.iqjb.hu.pm.intf.IqjbLogService;
import oracle.iqjb.hu.pm.intf.LogException;

/**
 *
 * @author oracle
 */
@Stateless(mappedName = "iqjbLogServiceBean")
@Remote(IqjbLogService.class)
public class IqjbLogServiceBean  implements IqjbLogService {

    @EJB
    private IqjbLogRepository1 iqjbLogRepository1;

    @EJB
    private IqjbLogRepository2 iqjbLogRepository2;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void create(String content) throws LogException {
        IqjbLog entry = new IqjbLog(content, LocalDateTime.now());
        iqjbLogRepository1.log(entry);
        iqjbLogRepository2.log(entry);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
