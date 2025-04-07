package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.models.EmsSite;
import com.repositories.EmsSiteRepository;

@Service
public class EmsSiteService {

    @Autowired
    private EmsSiteRepository siteRepository;

    public List<EmsSite> getAllDevices() {
        return siteRepository.findAll();
    }

    public Optional<EmsSite> getDeviceById(Long id) {
        return siteRepository.findById(id);
    }

    public List<EmsSite> getSiteByRegionId(Long id) {
        return siteRepository.findByRegionId(id);
    }

    public Optional<EmsSite> getSiteByName(String name) {
        return siteRepository.findByName(name);
    }

    public EmsSite createDevice(EmsSite emsSite) {
        return siteRepository.save(emsSite);
    }

    public void deleteDevice(Long id) {
        siteRepository.deleteById(id);
    }
}
