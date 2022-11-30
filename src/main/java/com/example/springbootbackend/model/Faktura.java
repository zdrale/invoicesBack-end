package com.example.springbootbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "faktura")
public class Faktura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "seller_name")
    private String sellerName;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "date")
    Date date;

    @Column(name = "amount")
    int amount;
}
