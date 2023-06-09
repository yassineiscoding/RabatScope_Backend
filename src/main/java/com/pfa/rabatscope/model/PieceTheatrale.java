package com.pfa.rabatscope.model;

import jakarta.persistence.*;
import lombok.*;

//import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class PieceTheatrale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPiece;
    private String nomPiece;
    private String lienAffiche;
    private Timestamp heureDebut;
    private Timestamp heureFin;
    @Lob
    private String description;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "sponsorship",
            joinColumns = @JoinColumn(
                    name = "id_piece",
                    referencedColumnName = "idPiece"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_sponsor",
                    referencedColumnName = "idSponsor"
            )
    )
    private List<Sponsor> sponsors;
}
