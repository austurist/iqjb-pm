/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.iqjb.hu.pm.db;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import oracle.iqjb.hu.pm.dm.Address;
import oracle.iqjb.hu.pm.dm.Department;
import oracle.iqjb.hu.pm.dm.Employee;
import oracle.iqjb.hu.pm.dm.EmployeeRole;
import oracle.iqjb.hu.pm.dm.Project;
import oracle.iqjb.hu.pm.dm.Task;

/**
 *
 * @author oracle
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("iqjbPU");
        EntityManager em = emf.createEntityManager();
        
        Map<String, Project> ps = createProjects();
        List<EmployeeRole> rl = createRoles();
        List<Employee> el = createEmployees(ps);
        
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        for (EmployeeRole er : rl) {
            em.persist(er);
        }
        
        for (Project p : ps.values()) {
            em.persist(p);
        }
        
        for (Employee e : el) {
            em.persist(e);
            e.getEmployeeroles().add(rl.get(ThreadLocalRandom.current().nextInt(4)));
            e.getEmployeeroles().add(rl.get(ThreadLocalRandom.current().nextInt(4)));
        }
        tx.commit();
    }
    
    private static List<Employee> createEmployees(Map<String, Project> ps) {
        List<Employee> el = new ArrayList<>();
        
        Department dept = new Department("one-and-only");
        
        Employee boss = new Employee();
        boss.setFirstName("Boss");
        boss.setLastName("Big");
        boss.setLoginname("bigboss");
        boss.setSalary(100000);
        
        boss.setAddress(new Address("****", "Emerald", "Gold"));
        boss.setDepartment(dept);
        
        ps.get("Inevitable Success").setLeader(boss);
        for (Task ts : ps.get("Inevitable Success").getTasks()) {
            ts.setOwner(boss);
        }
        
        el.add(boss);
        
        Employee joe = new Employee();
        joe.setFirstName("Joe");
        joe.setLastName("Small");
        joe.setLoginname("smalljoe");
        joe.setSalary(10);
        joe.setBoss(boss);
        
        joe.setAddress(new Address("0000", "Flea Bottom", "Dead End"));
        joe.setDepartment(dept);
        
        ps.get("Miserable Failure").setLeader(joe);
        for (Task ts : ps.get("Miserable Failure").getTasks()) {
            ts.setOwner(joe);
        }
        
        el.add(joe);
                
        return el;
    }
    
    private static Map<String, Project> createProjects () {
        Map<String, Project> mp = new HashMap<>();
        
        Project p0 = new Project("Miserable Failure", LocalDate.now(), LocalDate.now().plus(1000, ChronoUnit.DAYS));
        p0.getTasks().add(new Task("Long task"));
        p0.getTasks().add(new Task("Boring task"));
        p0.getTasks().add(new Task("Impossible task"));
        mp.put(p0.getName(), p0);
        
        Project p1 = new Project("Inevitable Success", LocalDate.now(), LocalDate.now().plus(1, ChronoUnit.DAYS));
        p1.getTasks().add(new Task("Trivial Task"));
        mp.put(p1.getName(), p1);
        
        return mp;
    }

    private static List<EmployeeRole> createRoles() {
        List<EmployeeRole> rl = new ArrayList<>();
        
        rl.add(new EmployeeRole("Keeper of the keys"));
        rl.add(new EmployeeRole("Genius in charge"));
        rl.add(new EmployeeRole("Scapegoat"));
        rl.add(new EmployeeRole("Innocent Adversary"));
        
        return rl;
    }
}
