package com.pfa.rabatscope.repository;

import com.pfa.rabatscope.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository
        extends JpaRepository<Media, Long> {
}
