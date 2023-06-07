package com.pfa.rabatscope.model;

import jakarta.persistence.*;
import lombok.*;

//import java.sql.Timestamp;
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

    private String heureDebut;

    private String heureFin;
    @ManyToOne
    @JoinColumn(
            name="id_sponsor",
            referencedColumnName = "idSponsor"
    )
    private Sponsor sponsor;
}
