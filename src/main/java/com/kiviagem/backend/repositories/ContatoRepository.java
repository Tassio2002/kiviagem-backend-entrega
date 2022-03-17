package com.kiviagem.backend.repositories;

import com.kiviagem.backend.models.Contato;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    
}
