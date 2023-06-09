package com.pfa.rabatscope.controller;

import com.pfa.rabatscope.model.Artiste;
import com.pfa.rabatscope.repository.ArtisteRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/artiste")
@CrossOrigin
public class ArtisteController {
    private final ArtisteRepository artisteRepository;
    public ArtisteController(ArtisteRepository artisteRepository){
        this.artisteRepository = artisteRepository;
    }
    @GetMapping
    public List<Artiste> getArtiste() {
        return artisteRepository.findAll();
    }

    @GetMapping("/{idArtiste}")
    public Optional<Artiste> getArtistebyId(@PathVariable("idArtiste") Long id) {
        return artisteRepository.findById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> saveArtiste(@RequestBody Artiste artisteData) {
        artisteRepository.save(artisteData);
        return ResponseEntity.ok("Data saved");
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{idArtiste}")
    public void deleteMedia(@PathVariable("idArtiste") Long id){
        artisteRepository.deleteById(id);

    }
    record UpdatedArtisteRequest(
//            Long idArtiste,
            String nomArtiste,
            Timestamp dateNaissance
    ) {}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{idArtiste}")
    public void updateArtiste(@PathVariable("idArtiste") Long id, @Valid @RequestBody UpdatedArtisteRequest request) {
        Artiste artiste = artisteRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found."));

        if (request.nomArtiste() != null) {
            artiste.setNomArtiste(request.nomArtiste());
        }
        if (request.dateNaissance() != null) {
            artiste.setDateNaissance(request.dateNaissance());
        }

        artisteRepository.save(artiste);
    }
}
