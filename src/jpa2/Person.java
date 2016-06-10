/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa2;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;


/**
 *
 * @author butwhole
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName,LastName;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDate;
    private int age;
    private boolean isMarried;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Grade grace;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Person supervisor;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Person> supers;
    
    
    public Person() {
    }

    public Person getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Person supervisor) {
        this.supervisor = supervisor;
    }

    public List<Person> getSupers() {
        return supers;
    }

    public void addSupers(Person personToBeSupervised) {
        this.supers.add(personToBeSupervised);
    }

    public Grade getGrace() {
        return grace;
    }

    public void setGrace(Grade grace) {
        this.grace = grace;
    }

    
    
    public Person(String firstName, String LastName, Date birthDate, int age, boolean isMarried) {
        this.firstName = firstName;
        this.LastName = LastName;
        this.birthDate = birthDate;
        this.age = age;
        this.isMarried = isMarried;
    }
    
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isIsMarried() {
        return isMarried;
    }

    public void setIsMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
}
