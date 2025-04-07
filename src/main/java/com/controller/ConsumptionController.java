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
import com.models.Consumption;
import com.service.ConsumptionService;

@RestController
@RequestMapping("/api/consumption")
public class ConsumptionController {
    @Autowired
    private ConsumptionService consumptionService;

    @GetMapping("/state")
    public List<Consumption> getAllDevicesConsumption() {
        return consumptionService.getAllDevicesConsumption();
    }

    @GetMapping("/region/{region}")
    public List<Consumption> getRegionDevices(@PathVariable String region) {
        return consumptionService.getRegionDevicesConsumption(region);
    }

    @GetMapping("/site/{site}")
    public List<Consumption> getSiteDevices(@PathVariable String site) {
        return consumptionService.getSiteDevicesConsumption(site);
    }

    @GetMapping("/{id}")
    public Optional<Consumption> getDeviceById(@PathVariable Long id) {
        return consumptionService.getDeviceById(id);
    }

    @PostMapping
    public Consumption createDevice(@RequestBody Consumption consumption) {
        return consumptionService.createDevice(consumption);
    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable Long id) {
        consumptionService.deleteDevice(id);
    }
}
