package com.klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id;
    private String name;
    private String gender;
    @Autowired
    private Certification certification;

    public Student() {
        this.id = 32040;
        this.name = "VIJJU";
        this.gender = "Female";
    }

    public void display() {
    	System.out.println("ID: "+ id);
    	System.out.println("Name: "+name);
    	System.out.println("Gende: "+gender);
    	System.out.println(certification);
    	System.out.println();

    }
}
