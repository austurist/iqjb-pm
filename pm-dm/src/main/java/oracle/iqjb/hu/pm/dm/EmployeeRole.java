/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.dm;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author oracle
 */
@Entity
public class EmployeeRole extends IqjbEntity implements Serializable {

    private String name;

    public EmployeeRole() {
    }

    public EmployeeRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" + "name=" + name + '}';
    }
    
}
