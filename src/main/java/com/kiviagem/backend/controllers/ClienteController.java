package com.kiviagem.backend.controllers;

import java.util.List;

import com.kiviagem.backend.models.Cliente;
import com.kiviagem.backend.repositories.ClienteRepository;

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
public class ClienteController {
    
    @Autowired
    private ClienteRepository cRepo;

    @GetMapping("/clientes")
    public List<Cliente> getAllClientes() {
        return cRepo.findAll();
    }

    @PostMapping("/clientes")
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        return cRepo.save(cliente);
    }

    @GetMapping("/clientes/{id}")
    public Cliente getSingleCliente(@PathVariable Long id) {
        return cRepo.findById(id).get();
    }

    @PutMapping("/clientes")
    public Cliente updateClienteDetails(@RequestBody Cliente cliente) {
        return cRepo.save(cliente);
    }
    
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<HttpStatus> deleteClienteById(@PathVariable Long id) {

        cRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
