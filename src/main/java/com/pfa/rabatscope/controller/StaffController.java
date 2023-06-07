package com.pfa.rabatscope.controller;

import com.pfa.rabatscope.model.Staff;
import com.pfa.rabatscope.repository.StaffRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/staff")
@CrossOrigin
public class StaffController {
    private final StaffRepository staffRepository;
    public StaffController(StaffRepository staffRepository){
        this.staffRepository = staffRepository;
    }
    @GetMapping
    public List<Staff> getStaff() {
        return staffRepository.findAll();
    }

    @GetMapping("/{idStaff}")
    public Optional<Staff> getStaffbyId(@PathVariable("idStaff") Long id) {
        return staffRepository.findById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> saveStaff(@RequestBody Staff staffData) {
        staffRepository.save(staffData);
        return ResponseEntity.ok("Data saved");
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{idStaff}")
    public void deleteStaff(@PathVariable("idStaff") Long id){
        staffRepository.deleteById(id);

    }
    record UpdatedStaffRequest(
            Long idStaff,
            String nom,
            String fonction,
            Integer salaire
    ) {}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{idStaff}")
    public void updateStaff(@PathVariable("idStaff") Long id, @Valid @RequestBody StaffController.UpdatedStaffRequest request) {
        Staff staff = staffRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found."));


        if (request.nom() != null) {
            staff.setNom(request.nom());
        }
        if (request.fonction() != null) {
            staff.setFonction(request.fonction());
        }
        if (request.salaire() != null) {
            staff.setSalaire(request.salaire());
        }
        staffRepository.save(staff);
    }
}
