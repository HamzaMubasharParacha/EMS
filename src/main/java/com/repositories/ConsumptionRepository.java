package com.repositories;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.models.Consumption;

public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {
    Collection<? extends Consumption> getByDeviceId(Long deviceId);
    // For today's consumption
    List<Consumption> findByDeviceIdAndRecordedTimeBetween(Long deviceId, LocalDateTime start, LocalDateTime end);

    // If you want all consumption of a region for a given time range
    List<Consumption> findByRecordedTimeBetween(LocalDateTime start, LocalDateTime end);
}
