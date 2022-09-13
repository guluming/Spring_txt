package com.example.spring_txt.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String gender;

    @Column
    private int pay;

    public Users(Long id, String name, int age, String gender, int pay) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.pay = pay;
    }
}
