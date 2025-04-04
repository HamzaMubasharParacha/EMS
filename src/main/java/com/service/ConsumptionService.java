package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.models.Consumption;
import com.models.EmsDevice;
import com.repositories.ConsumptionRepository;

@Service
public class ConsumptionService {
    @Autowired
    private ConsumptionRepository consumptionRepository;

    public List<Consumption> getAllDevices() {
        return consumptionRepository.findAll();
    }

    public Optional<Consumption> getDeviceById(Long id) {
        return consumptionRepository.findById(id);
    }

    public Consumption createDevice(Consumption consumption) {
        return consumptionRepository.save(consumption);
    }

    public void deleteDevice(Long id) {
        consumptionRepository.deleteById(id);
    }
}
