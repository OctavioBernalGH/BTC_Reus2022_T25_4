package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Salas;

@Repository
public interface SalasDAO extends JpaRepository<Salas,Long>{

}
