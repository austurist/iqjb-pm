/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.dm;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author oracle
 */
@Entity
public class Department extends IqjbEntity implements Serializable {

    private String name;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" + "name=" + name + '}';
    }
    
    
}
