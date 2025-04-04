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

import com.models.EmsDevice;
import com.service.EmsDeviceService;

@RestController
@RequestMapping("/api/devices")
public class EmsDeviceController {

    @Autowired
    private EmsDeviceService emsDeviceService;

    @GetMapping
    public List<EmsDevice> getAllDevices() {
        return emsDeviceService.getAllDevices();
    }

    @GetMapping("/{id}")
    public Optional<EmsDevice> getDeviceById(@PathVariable Long id) {
        return emsDeviceService.getDeviceById(id);
    }

    @PostMapping
    public EmsDevice createDevice(@RequestBody EmsDevice emsDevice) {
        return emsDeviceService.createDevice(emsDevice);
    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable Long id) {
        emsDeviceService.deleteDevice(id);
    }
}
