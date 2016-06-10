/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa2;

import java.util.Date;
import javax.persistence.Persistence;

/**
 *
 * @author butwhole
 */
public class JPA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persistence.generateSchema("PU", null);
        ControllerFacade con = new ControllerFacade();
        Date date = new Date(-778636800000L);
        Long time = ((new Date().getTime() + 778636800000L) / 31556926000L);
        int age = Integer.parseInt(time.toString());
        Grade grad = new Grade();
        grad.setName("Hitler'ish reincarnation");
        grad.setValue(9001);
        con.addStudent("David", "Sucky Sucky",date,age, true, 25, new Date(), new Grade());
        con.addEmployee("Alex", "Sucky ducky", date, age, true, 25, 1000F, "derp", new Grade());
        con.addEmployee("marco", "Sucky ducky", date, age, true, 25, 1000F, "derp", new Grade());
        Student stud = con.findStudent(1);
        Employee emp = con.findEmployee(2);
        Employee emp2 = con.findEmployee(3);
        con.setSuper(stud, emp);
        con.setSuper(stud, emp2);
        con.Done();
        ControllerFacade con2 = new ControllerFacade();
        for (Person p : con2.superList(1)) {
            System.out.println(p.getSupervisor().getId());
        }
        System.out.println(con2.getSuper(2).getId());
        System.out.println(con2.getSuper(3).getId());
        
        
       
        
        
    }

}
