package com.pfa.rabatscope.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Artiste {
    @Id
    @SequenceGenerator(
            name = "artiste_id_sequence",
            sequenceName = "artiste_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "artiste_id_sequence"
    )
    @Column(unique = true, nullable = false)
    private Long idArtiste;
    private String nomArtiste;
    private Timestamp dateNaissance;
    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(
            name = "Roles",
            joinColumns = @JoinColumn(
                    name = "id_artiste",
                    referencedColumnName = "idArtiste"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_piece",
                    referencedColumnName = "idPiece"
            )
    )
    private List<PieceTheatrale> piecesTheatrales;
}
