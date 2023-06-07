package com.pfa.rabatscope.controller;

import com.pfa.rabatscope.model.Sponsor;
import com.pfa.rabatscope.repository.SponsorRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/sponsor")
@CrossOrigin
public class SponsorController {
    private final SponsorRepository sponsorRepository;
    public SponsorController(SponsorRepository sponsorRepository){
        this.sponsorRepository = sponsorRepository;
    }
    @GetMapping
    public List<Sponsor> getSponsor() {
        return sponsorRepository.findAll();
    }

    @GetMapping("/{idSponsor}")
    public Optional<Sponsor> getSponsorbyId(@PathVariable("idSponsor") Long id) {
        return sponsorRepository.findById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> saveSponsor(@RequestBody Sponsor sponsorData) {
        sponsorRepository.save(sponsorData);
        return ResponseEntity.ok("Data saved");
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{idSponsor}")
    public void deleteSponsor(@PathVariable("idSponsor") Long id){
        sponsorRepository.deleteById(id);

    }
    record UpdatedSponsorRequest(
            Long idSponsor,
            String nomSponsor,
            Integer sponsorship,
            String contactSponsor
    ) {}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{idSponsor}")
    public void updateSponsor(@PathVariable("idSponsor") Long id, @Valid @RequestBody SponsorController.UpdatedSponsorRequest request) {
        Sponsor sponsor = sponsorRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found."));

        if (request.idSponsor() != null) {
            sponsor.setIdSponsor(request.idSponsor());
        }
        if (request.nomSponsor() != null) {
            sponsor.setNomSponsor(request.nomSponsor());
        }
        if (request.sponsorship() != null) {
            sponsor.setSponsorship(request.sponsorship());
        }
        if (request.contactSponsor() != null) {
            sponsor.setContactSponsor(request.contactSponsor());
        }
        sponsorRepository.save(sponsor);
    }
}
