package com.example.springbootbackend.repository;

import com.example.springbootbackend.model.Faktura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FakturaRepository extends JpaRepository<Faktura, Long> {

}
