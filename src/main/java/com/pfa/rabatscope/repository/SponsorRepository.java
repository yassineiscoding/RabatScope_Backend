package com.pfa.rabatscope.repository;

import com.pfa.rabatscope.model.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorRepository
        extends JpaRepository<Sponsor, Long> {
}
