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
import com.models.EmsCustomer;
import com.service.EmsCustomerService;

@RestController
@RequestMapping("/api/customer")
public class EmsCustomerController {

    @Autowired
    private EmsCustomerService emsCustomerService;

    @GetMapping
    public List<EmsCustomer> getAllDevices() {
        return emsCustomerService.getAllDevices();
    }

    @GetMapping("/{id}")
    public Optional<EmsCustomer> getDeviceById(@PathVariable Long id) {
        return emsCustomerService.getDeviceById(id);
    }

    @PostMapping
    public EmsCustomer createDevice(@RequestBody EmsCustomer emsCustomer) {
        return emsCustomerService.createDevice(emsCustomer);
    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable Long id) {
        emsCustomerService.deleteDevice(id);
    }
}
