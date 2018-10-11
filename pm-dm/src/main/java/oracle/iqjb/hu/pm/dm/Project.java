/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.dm;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author oracle
 */
@Entity
public class Project extends IqjbEntity implements Serializable {
    
    private String name;

    @Convert(converter = oracle.iqjb.hu.pm.dm.LocalDateConverter.class)
    private LocalDate fromDate;
    
    @Convert(converter = oracle.iqjb.hu.pm.dm.LocalDateConverter.class)
    private LocalDate toDate;
    
    @ManyToOne
    private Employee leader;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    public Project() {
    }

    public Project(String name, LocalDate fromDate, LocalDate toDate) {
        this.name = name;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    /*
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    */

    @Override
    public String toString() {
        return "Project{" + "name=" + name + ", fromDate=" + fromDate + ", leader=" + leader + '}';
    }
    
    
    
}
