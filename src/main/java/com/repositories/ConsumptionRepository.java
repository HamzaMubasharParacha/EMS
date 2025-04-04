package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.models.Consumption;

public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {
}
