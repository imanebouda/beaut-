package com.management.repositories;

import com.management.entities.Parfum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagasinRepository extends JpaRepository<Parfum, Long> {
}
