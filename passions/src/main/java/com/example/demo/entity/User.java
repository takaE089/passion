package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

    
@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "control_num")
    private String controlNum;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password; 
        
        
    @Column(name = "name")
    private String name;
    
    @Column(name = "ruby")
    private String ruby;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "hobby")
    private String hobby;
    
    @Column(name = "introduction")
    private String introduction;


}