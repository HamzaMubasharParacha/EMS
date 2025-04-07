package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.models.EmsRegion;
import com.repositories.EmsRegionRepository;


@Service
public class EmsRegionService {

    @Autowired
    private EmsRegionRepository emsRegionRepository;

    public List<EmsRegion> getAllRegions() {
        return emsRegionRepository.findAll();
    }

    public Optional<EmsRegion> getRegionById(Long id) {
        return emsRegionRepository.findById(id);
    }

    public Optional<EmsRegion> getRegionByName(String name) {
        return emsRegionRepository.findByName(name);
    }

    public EmsRegion createRegion(EmsRegion emsRegion) {
        return emsRegionRepository.save(emsRegion);
    }

    public void deleteRegion(Long id) {
        emsRegionRepository.deleteById(id);
    }
}
