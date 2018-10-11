/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.intf;

import java.io.Serializable;

/**
 *
 * @author oracle
 */
public class AddDepartmentRequest implements Serializable{
    private String dept;

    public AddDepartmentRequest(String dept) {
        this.dept = dept;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
    
    
}
