package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.models.EmsDevice;


public interface EmsDeviceRepository extends JpaRepository<EmsDevice, Long> {
}
