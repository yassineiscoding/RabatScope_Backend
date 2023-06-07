package com.pfa.rabatscope.controller;

import com.pfa.rabatscope.model.Salle;

import com.pfa.rabatscope.repository.SalleRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/salle")
@CrossOrigin
public class SalleController {
    private final SalleRepository salleRepository;
    public SalleController(SalleRepository salleRepository){
        this.salleRepository = salleRepository;
    }
    @GetMapping
    public List<Salle> getSalle() {return salleRepository.findAll();}
    @GetMapping("/{idSalle}")
    public Optional<Salle> getSalleById(@PathVariable("idSalle") Long id) {
        return salleRepository.findById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> saveSalles(@RequestBody Salle salleData) {
        salleRepository.save(salleData);
        return ResponseEntity.ok("Data saved");
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{idSalle}")
    public void deleteSalle(@PathVariable("idSalle") Long id){
        salleRepository.deleteById(id);
    }
}
