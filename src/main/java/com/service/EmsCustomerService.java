package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.models.EmsCustomer;
import com.models.EmsDevice;
import com.repositories.EmsCustomerRepository;

@Service
public class EmsCustomerService {

    @Autowired
    private EmsCustomerRepository customerRepository;

    public List<EmsCustomer> getAllDevices() {
        return customerRepository.findAll();
    }

    public Optional<EmsCustomer> getDeviceById(Long id) {
        return customerRepository.findById(id);
    }

    public EmsCustomer createDevice(EmsCustomer emsCustomer) {
        return customerRepository.save(emsCustomer);
    }

    public void deleteDevice(Long id) {
        customerRepository.deleteById(id);
    }
}
