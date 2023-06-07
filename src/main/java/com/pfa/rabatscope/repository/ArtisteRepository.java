package com.pfa.rabatscope.repository;

import com.pfa.rabatscope.model.Artiste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtisteRepository
        extends JpaRepository<Artiste, Long> {
}
