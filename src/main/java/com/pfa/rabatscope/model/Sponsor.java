package com.pfa.rabatscope.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Sponsor {
    @Id
    @SequenceGenerator(
            name = "sponsor_id_sequence",
            sequenceName = "sponsor_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sponsor_id_sequence"
    )
    @Column(unique = true, nullable = false)
    private Long idSponsor;
    @Column(nullable = false)
    private String nomSponsor;
    private Integer sponsorship;
    private String contactSponsor;
}
