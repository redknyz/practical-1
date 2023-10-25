package com.mypackage.User;

import javax.persistence.*;

@Entity
@Table(name = "crews")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcrews;

    private String name;
    private int members;
    private int age;

    public String getName() {
        return name;
    }

    public int getMembers() {
        return members;
    }

    public int getAge() {
        return age;
    }


}