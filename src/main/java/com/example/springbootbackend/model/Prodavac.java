package com.example.springbootbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prodavac")
public class Prodavac {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;
 @Column(name = "company_name")
 private String companyName;
 @Column(name = "hq_adress")
 private String hqAdress;
 @Column(name= "is_active")
 boolean isActive;
}
