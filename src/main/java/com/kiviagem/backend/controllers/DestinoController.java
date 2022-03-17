package com.kiviagem.backend.controllers;

import java.util.List;

import com.kiviagem.backend.models.Destino;
import com.kiviagem.backend.repositories.DestinoRepository;

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
public class DestinoController {
    
    @Autowired
    private DestinoRepository dRepo;

    @GetMapping("/destinos")
    public List<Destino> getAllDestinos() {
        return dRepo.findAll();
    }

    @PostMapping("/destinos")
    public Destino saveDestino(@RequestBody Destino destino) {
        return dRepo.save(destino);
    }

    @GetMapping("/destinos/{id}")
    public Destino getSingleDestino(@PathVariable Long id) {
        return dRepo.findById(id).get();
    }

    @PutMapping("/destinos")
    public Destino updateDestinoDetails(@RequestBody Destino destino) {
        return dRepo.save(destino);
    }
    
    @DeleteMapping("/destinos/{id}")
    public ResponseEntity<HttpStatus> deleteDestinoById(@PathVariable Long id) {

        dRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
