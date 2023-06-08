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
public class Media {
    @Id
    @SequenceGenerator(
            name = "media_id_sequence",
            sequenceName = "media_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "media_id_sequence"
    )
    @Column(unique = true, nullable = false)
    private Long idMedia;
    @Column(nullable = false)
    private String nomMedia;
    private String typeMedia;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name= "id_piece",
            referencedColumnName = "idPiece"
    )
    private PieceTheatrale pieceTheatrale;
}
