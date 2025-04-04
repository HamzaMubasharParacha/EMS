package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.EmsDevice;
import com.repositories.EmsDeviceRepository;

@Service
public class EmsDeviceService {

    @Autowired
    private EmsDeviceRepository emsDeviceRepository;

    public List<EmsDevice> getAllDevices() {
        return emsDeviceRepository.findAll();
    }

    public Optional<EmsDevice> getDeviceById(Long id) {
        return emsDeviceRepository.findById(id);
    }

    public EmsDevice createDevice(EmsDevice emsDevice) {
        return emsDeviceRepository.save(emsDevice);
    }

    public void deleteDevice(Long id) {
        emsDeviceRepository.deleteById(id);
    }
}
