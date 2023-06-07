package com.pfa.rabatscope.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    @Id
    @SequenceGenerator(
            name = "staff_id_sequence",
            sequenceName = "staff_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "staff_id_sequence"
    )
    @Column(unique = true, nullable = false)
    private Long idStaff;
    @Column(nullable = false)
    private String nom;
    private String fonction;
    private Integer salaire;

}
