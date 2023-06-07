package com.pfa.rabatscope.controller;


import com.pfa.rabatscope.model.PieceTheatrale;
import com.pfa.rabatscope.model.Ticket;
import com.pfa.rabatscope.repository.TicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/ticket")
@CrossOrigin
public class TicketController {
    private final TicketRepository ticketRepository;
    public TicketController(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }
    @GetMapping
    public List<Ticket> getTicket() {return ticketRepository.findAll();}
    @GetMapping("/{idTicket}")
    public Optional<Ticket> getTicketById(@PathVariable("idTicket") Long id) {
        return ticketRepository.findById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> saveTickets(@RequestBody Ticket ticketData) {
        ticketRepository.save(ticketData);
        return ResponseEntity.ok("Data saved");
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{idTicket}")
    public void deleteTicket(@PathVariable("idTicket") Long id){
        ticketRepository.deleteById(id);
    }
}
