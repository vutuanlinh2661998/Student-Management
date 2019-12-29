/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author BVCN 88
 */
public class Student implements Serializable{
    final long serialVersionUID = 1L;
    private int id;
    private String name;
    private Date dob;

    public Student(int id, String name, Date dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    public Object [] toObject (){
        return new Object[]{id, name, new SimpleDateFormat("dd/MM/yyyy").format(dob)};
    }
    
    public String [] toNewString(){
        return new String []{Integer.toString(id),name,new SimpleDateFormat("dd/MM/yyyy").format(dob)};
    }
    
}
