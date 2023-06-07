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
public class Manager {
    @Id
    @SequenceGenerator(
            name = "manager_id_sequence",
            sequenceName = "manager_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "manager_id_sequence"
    )
    @Column(unique = true, nullable = false)
    private Long idManager;
    private String nomManager;
    private String contactManager;
    @ManyToMany
    @JoinTable(
            name = "management",
            joinColumns = @JoinColumn(
                    name = "id_manager",
                    referencedColumnName = "idManager"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_artiste",
                    referencedColumnName = "idArtiste"
            )
    )
    private List<Artiste> artistes;
}
