package com.kiviagem.backend.controllers;

import java.util.List;

import com.kiviagem.backend.models.Contato;
import com.kiviagem.backend.repositories.ContatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ContatoController {
    
    @Autowired
    private ContatoRepository contRepo;

    @GetMapping("/contatos")
    public List<Contato> getAllContatos() {
        return contRepo.findAll();
    }

    @PostMapping("/contatos")
    public Contato saveContato(@RequestBody Contato contato) {
        return contRepo.save(contato);
    }

    @GetMapping("/contatos/{id}")
    public Contato getSingleContato(@PathVariable Long id) {
        return contRepo.findById(id).get();
    }

    @PutMapping("/contatos")
    public Contato updateContatoDetails(@RequestBody Contato contato) {
        return contRepo.save(contato);
    }
    
    @DeleteMapping("/contatos/{id}")
    public ResponseEntity<HttpStatus> deleteContatoById(@PathVariable Long id) {

        contRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

