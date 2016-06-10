/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author butwhole
 */
public class ControllerFacade {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    private EntityManager em = emf.createEntityManager();
    
    public void addStudent(String firstName, String lastName, Date birthDate, int age, boolean isMarried, int matNr, Date matDate, Grade grace){
        Student p = new Student();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setBirthDate(birthDate);
        p.setAge(age);
        p.setIsMarried(isMarried);
        p.setMatDate(matDate);
        p.setMatNr(matNr);
        p.setGrace(grace);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
    }
    
    public void addEmployee(String firstName, String lastName, Date birthDate, int age, boolean isMarried, int soSecNr, float wage, String taxClass, Grade grace){
        Employee p = new Employee();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setBirthDate(birthDate);
        p.setAge(age);
        p.setIsMarried(isMarried);
        p.setSoSecNr(soSecNr);
        p.setWage(wage);
        p.setTaxClass(taxClass);
        p.setGrace(grace);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public void editStudent(int id, boolean isMarried, int matNr, Date matDate, Grade grace){
        Student p = findStudent(id);
        
        p.setIsMarried(isMarried);
        p.setMatDate(matDate);
        p.setMatNr(matNr);
        p.setGrace(grace);
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
    
    public void editEmployee(int id, boolean isMarried, float wage, String taxClass, Grade grace){
        Employee p = findEmployee(id);
        p.setIsMarried(isMarried);
        p.setWage(wage);
        p.setTaxClass(taxClass);
        p.setGrace(grace);
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
    
    public Student findStudent(int id){
        return em.find(Student.class, id);
    }
    
    public Employee findEmployee(int id){
        return em.find(Employee.class, id);
    }
 
    public void deleteStudent(int id){
        em.getTransaction().begin();
        em.remove(em.find(Person.class, id));
        em.getTransaction().commit();
    }
    
    public void setSuper(Person superP, Person p){
        
        em.getTransaction().begin();
        superP.addSupers(p);
        p.setSupervisor(superP);
        em.getTransaction().commit();
    }

    public List<Person> superList(int superId){
        return em.find(Person.class, superId).getSupers();
    }
    
    public Person getSuper(int id){
        return em.find(Person.class, id).getSupervisor();
    }
    
    public void Done(){
        em.close();
    }
    
}
