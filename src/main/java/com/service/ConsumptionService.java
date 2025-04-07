package com.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.models.Consumption;
import com.models.EmsDevice;
import com.models.EmsRegion;
import com.models.EmsSite;
import com.repositories.ConsumptionRepository;

@Service
public class ConsumptionService {
    @Autowired
    private ConsumptionRepository consumptionRepository;
    @Autowired
    private EmsRegionService emsRegionService;
    @Autowired
    private EmsDeviceService emsDeviceService;
    @Autowired
    private EmsSiteService emsSiteService;

    public List<Consumption> getAllDevicesConsumption() {
        return consumptionRepository.findAll();
    }

    public List<Consumption> getRegionDevicesConsumption(String regionName) {
        Optional<EmsRegion> emsRegion = emsRegionService.getRegionByName(regionName);
        if (emsRegion.isEmpty()) {
            return Collections.emptyList();
        }
        List<EmsSite> emsSites = emsSiteService.getSiteByRegionId(emsRegion.get().getId());
        List<EmsDevice> emsDevices = emsSites.stream()
                .map(emsSite -> emsDeviceService.getDeviceBySiteId(emsSite.getId()))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return getConsumptionList(emsDevices);
    }

    public List<Consumption> getSiteDevicesConsumption(String site) {
        Optional<EmsSite> emsSiteOptional = emsSiteService.getSiteByName(site);
        if (emsSiteOptional.isEmpty()) {
            return Collections.emptyList();
        }

        EmsSite emsSite = emsSiteOptional.get();
        List<EmsDevice> emsDevices = emsDeviceService.getDeviceBySiteId(emsSite.getId());

        return getConsumptionList(emsDevices);
    }

    public Optional<Consumption> getDeviceById(Long id) {
        return consumptionRepository.findById(id);
    }

    public Consumption createDevice(Consumption consumption) {
        return consumptionRepository.save(consumption);
    }

    public void deleteDevice(Long id) {
        consumptionRepository.deleteById(id);
    }

    private List<Consumption> getConsumptionList(List<EmsDevice> emsDevices) {
        if (emsDevices.isEmpty()) {
            return Collections.emptyList();
        }

        return emsDevices.stream()
                .map(EmsDevice::getId)
                .map(consumptionRepository::getByDeviceId)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
