package com.pfa.rabatscope.repository;

import com.pfa.rabatscope.model.PieceTheatrale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceTheatraleRepository
        extends JpaRepository<PieceTheatrale, Long> {
}
