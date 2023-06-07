package com.pfa.rabatscope.controller;

import com.pfa.rabatscope.model.Manager;
import com.pfa.rabatscope.model.Media;
import com.pfa.rabatscope.model.Staff;
import com.pfa.rabatscope.repository.MediaRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/media")
@CrossOrigin
public class MediaController {
    private final MediaRepository mediaRepository;
    public MediaController(MediaRepository mediaRepository){
        this.mediaRepository = mediaRepository;
    }
    @GetMapping
    public List<Media> getMedia() {
        return mediaRepository.findAll();
    }

    @GetMapping("/{idMedia}")
    public Optional<Media> getMediabyId(@PathVariable("idMedia") Long id) {
        return mediaRepository.findById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> saveMedia(@RequestBody Media mediaData) {
        mediaRepository.save(mediaData);
        return ResponseEntity.ok("Data saved");
    }

    /*@PostMapping("/multiple")
    public ResponseEntity<String> saveMultipleMedia(@RequestBody List<Media> mediaData) {
        mediaRepository.saveAll(mediaData);
        return ResponseEntity.ok("Data saved");
    }*/

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{idMedia}")
    public void deleteMedia(@PathVariable("idMedia") Long id){
        mediaRepository.deleteById(id);

    }
    record UpdatedMediaRequest(
            Long idMedia,
            String nomMedia,
            String typeMedia
    ) {}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{idMedia}")
    public void updateStaff(@PathVariable("idMedia") Long id, @Valid @RequestBody UpdatedMediaRequest request) {
        Media media = mediaRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found."));

        if (request.nomMedia() != null) {
            media.setNomMedia(request.nomMedia());
        }
        if (request.typeMedia() != null) {
            media.setTypeMedia(request.typeMedia());
        }

        mediaRepository.save(media);
    }
}
