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
import com.models.EmsSite;
import com.service.EmsSiteService;

@RestController
@RequestMapping("/api/site")
public class EmsSiteController {

    @Autowired
    private EmsSiteService emsSiteService;

    @GetMapping
    public List<EmsSite> getAllDevices() {
        return emsSiteService.getAllDevices();
    }

    @GetMapping("/{id}")
    public Optional<EmsSite> getDeviceById(@PathVariable Long id) {
        return emsSiteService.getDeviceById(id);
    }

    @PostMapping
    public EmsSite createDevice(@RequestBody EmsSite emsSite) {
        return emsSiteService.createDevice(emsSite);
    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable Long id) {
        emsSiteService.deleteDevice(id);
    }
}
