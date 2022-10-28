package com.example.meditationbackend.Models.authModels;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="id")
    private Long id;


    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "Name" )
    private String name;
    @Column(name = "Login")
    private String login;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Roles Role;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status Status;


}
