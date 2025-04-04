package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.EmsRegion;
import com.service.EmsRegionService;

@RestController
@RequestMapping("/api/regions")
public class EmsRegionController {

    @Autowired
    private EmsRegionService emsRegionService;


    @GetMapping
    public List<EmsRegion> getAllRegions() {
        return emsRegionService.getAllRegions();
    }

    @GetMapping("/{id}")
    public Optional<EmsRegion> getRegionById(@PathVariable Long id) {
        return emsRegionService.getRegionById(id);
    }

    @PostMapping
    public EmsRegion createRegion(@RequestBody EmsRegion emsRegion) {
        return emsRegionService.createRegion(emsRegion);
    }

    @DeleteMapping("/{id}")
    public void deleteRegion(@PathVariable Long id) {
        emsRegionService.deleteRegion(id);
    }
}

