package com.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.models.EmsSite;

public interface EmsSiteRepository extends JpaRepository<EmsSite, Long> {
    List<EmsSite> findByRegionId(Long id);

    Optional<EmsSite> findByName(String name);
}
