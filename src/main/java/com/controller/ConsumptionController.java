package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/region/{regionName}/today")
    public ResponseEntity<List<Consumption>> getTodayConsumptionByRegion(@PathVariable String regionName) {
        List<Consumption> data = consumptionService.getTodayConsumptionByRegion(regionName);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/region/{regionName}/month")
    public ResponseEntity<List<Consumption>> getThisMonthConsumptionByRegion(@PathVariable String regionName) {
        List<Consumption> data = consumptionService.getThisMonthConsumptionByRegion(regionName);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/region/{regionName}/year/{year}/month/{month}")
    public ResponseEntity<List<Consumption>> getThisYearConsumptionByRegion(@PathVariable String regionName,
                                                                            @PathVariable int year,
                                                                            @PathVariable int month) {
        List<Consumption> data = consumptionService.getConsumptionByRegionAndMonth(regionName,year,month);
        return ResponseEntity.ok(data);
    }


    @GetMapping("/site/{site}")
    public List<Consumption> getSiteDevices(@PathVariable String site) {
        return consumptionService.getSiteDevicesConsumption(site);
    }

    @GetMapping("/region/{siteName}/today")
    public ResponseEntity<List<Consumption>> getTodayConsumptionBySite(@PathVariable String siteName) {
        List<Consumption> data = consumptionService.getTodayConsumptionBySite(siteName);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/region/{siteName}/month")
    public ResponseEntity<List<Consumption>> getThisMonthConsumptionBySite(@PathVariable String siteName) {
        List<Consumption> data = consumptionService.getThisMonthConsumptionBySite(siteName);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/region/{siteName}/year/{year}/month/{month}")
    public ResponseEntity<List<Consumption>> getThisYearConsumptionBySite(@PathVariable String siteName,
                                                                            @PathVariable int year,
                                                                            @PathVariable int month) {
        List<Consumption> data = consumptionService.getConsumptionBySiteAndMonth(siteName,year,month);
        return ResponseEntity.ok(data);
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
