package com.kiviagem.backend.repositories;

import com.kiviagem.backend.models.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}