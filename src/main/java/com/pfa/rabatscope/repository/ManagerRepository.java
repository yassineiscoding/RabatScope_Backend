package com.pfa.rabatscope.repository;

import com.pfa.rabatscope.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository
        extends JpaRepository<Manager, Long> {
}
