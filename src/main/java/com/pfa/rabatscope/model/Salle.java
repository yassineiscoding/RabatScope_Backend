package com.pfa.rabatscope.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Salle {
    @Id
    @SequenceGenerator(
            name = "salle_id_sequence",
            sequenceName = "salle_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "salle_id_sequence"
    )
    @Column(unique = true, nullable = false)
    private Long idSalle;
    @Column(nullable = false)
    private Integer nbrePlaces;
    @OneToMany
    @JoinColumn(
            name = "id_salle",
            referencedColumnName = "idSalle"
    )
    private List<Staff> staffs;
    @ManyToMany
    @JoinTable(
            name = "localisation",
            joinColumns = @JoinColumn(
                    name = "id_salle",
                    referencedColumnName = "idSalle"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_piece",
                    referencedColumnName = "idPiece"
            )
    )
    private List<PieceTheatrale> piecesTheatrales;
}
