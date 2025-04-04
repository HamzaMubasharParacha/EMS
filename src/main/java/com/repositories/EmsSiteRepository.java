package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.models.EmsSite;

public interface EmsSiteRepository extends JpaRepository<EmsSite, Long> {
}
