package com.pfa.rabatscope.controller;


import com.pfa.rabatscope.model.Manager;
import com.pfa.rabatscope.repository.ManagerRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/manager")
@CrossOrigin
public class ManagerController {
    private final ManagerRepository managerRepository;
    public ManagerController(ManagerRepository managerRepository){
        this.managerRepository = managerRepository;
    }
    @GetMapping
    public List<Manager> getManager() {
        return managerRepository.findAll();
    }

    @GetMapping("/{idManager}")
    public Optional<Manager> getManagerbyId(@PathVariable("idManager") Long id) {
        return managerRepository.findById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> saveManager(@RequestBody Manager managerData) {
        managerRepository.save(managerData);
        return ResponseEntity.ok("Data saved");
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{idManager}")
    public void deleteManager(@PathVariable("idManager") Long id){
        managerRepository.deleteById(id);

    }
    record UpdatedManagerRequest(
            String nomManager,
            String contactManager
    ) {}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{idManager}")
    public void updateManager(@PathVariable("idManager") Long id, @Valid @RequestBody UpdatedManagerRequest request) {
        Manager manager = managerRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found."));

        if (request.nomManager() != null) {
            manager.setNomManager(request.nomManager());
        }
        if (request.contactManager() != null) {
            manager.setContactManager(request.contactManager());
        }

        managerRepository.save(manager);
    }
}
