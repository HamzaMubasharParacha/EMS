package com.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.models.EmsRegion;

public interface EmsRegionRepository extends JpaRepository<EmsRegion, Long> {
    Optional<EmsRegion> findByName(String name);
}
