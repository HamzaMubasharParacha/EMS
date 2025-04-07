package com.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.models.EmsDevice;


public interface EmsDeviceRepository extends JpaRepository<EmsDevice, Long> {
    List<EmsDevice> findBySiteId(Long id);
}
