package com.pfa.rabatscope.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false)
    private Long idTicket;
    private String dateReservation;
    @OneToOne
    @JoinColumn(
            name="id_piece",
            referencedColumnName = "idPiece"
    )
    private PieceTheatrale pieceTheatrale;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "id_ticket",
            referencedColumnName = "idTicket"
    )
    private List<Client> clients;
}
