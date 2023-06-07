package com.pfa.rabatscope.controller;


import com.pfa.rabatscope.model.PieceTheatrale;
import com.pfa.rabatscope.repository.PieceTheatraleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/piecetheatrale")
@CrossOrigin
public class PieceTheatraleController {
    @Autowired
    private PieceTheatraleRepository pieceTheatraleRepository;
    /*public PieceTheatraleController(PieceTheatraleRepository pieceTheatraleRepository){
        this.pieceTheatraleRepository = pieceTheatraleRepository;
    }*/
    @GetMapping
    public List<PieceTheatrale> getPieceTheatrale() {return pieceTheatraleRepository.findAll();}
    @GetMapping("/{idPiece}")
    public Optional<PieceTheatrale> getPieceTheatraleById(@PathVariable("idPiece") Long id) {
        return pieceTheatraleRepository.findById(id);
    }
    record NewPieceTheatraleRequest (
            String nomPiece,
            String lienAffiche,
            String heureDebut,
            String heureFin
    ){}
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addPieceTheatrale(@RequestBody NewPieceTheatraleRequest request) {
        PieceTheatrale pieceTheatrale = new PieceTheatrale();
        pieceTheatrale.setNomPiece(request.nomPiece());
        pieceTheatrale.setLienAffiche(request.lienAffiche());
        pieceTheatrale.setHeureDebut(request.heureDebut());
        pieceTheatrale.setHeureFin(request.heureFin());
        pieceTheatraleRepository.save(pieceTheatrale);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{idPiece}")
    public void deletePieceTheatrale(@PathVariable("idPiece") Long id){
        pieceTheatraleRepository.deleteById(id);

    }
    record UpdatedPieceTheatraleRequest(
            String nomPiece,
            String lienAffiche,
            String heureDebut,
            String heureFin
    ) {}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{idPiece}")
    public void updateCustomer(@PathVariable("idPiece") Long id, @Valid @RequestBody  UpdatedPieceTheatraleRequest request) {
        PieceTheatrale pieceTheatrale = pieceTheatraleRepository.findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found."));

        if (request.nomPiece() != null) {
            pieceTheatrale.setNomPiece(request.nomPiece());
        }
        if (request.lienAffiche() != null) {
            pieceTheatrale.setLienAffiche(request.lienAffiche());
        }
        if (request.heureDebut() != null) {
            pieceTheatrale.setHeureDebut(request.heureDebut());
        }
        if (request.nomPiece() != null) {
            pieceTheatrale.setHeureFin(request.heureFin());
        }
        pieceTheatraleRepository.save(pieceTheatrale);
    }
}
