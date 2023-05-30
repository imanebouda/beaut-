package com.management.repositories;

import com.management.entities.Parfum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParfumRepository extends JpaRepository<Parfum, Long> {

}
