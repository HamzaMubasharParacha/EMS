package com.util;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.models.Consumption;
import com.models.EmsDevice;
import com.repositories.ConsumptionRepository;
import com.service.EmsDeviceService;
import com.service.EmsRegionService;
import com.service.EmsSiteService;

@Component
public class ConsumptionHelper {

    @Autowired
    private ConsumptionRepository consumptionRepository;
    @Autowired
    private EmsRegionService emsRegionService;
    @Autowired
    private EmsDeviceService emsDeviceService;
    @Autowired
    private EmsSiteService emsSiteService;

    public List<EmsDevice> getDevicesByRegion(String regionName) {
        return emsRegionService.getRegionByName(regionName)
                .map(region -> emsSiteService.getSiteByRegionId(region.getId()))
                .orElse(Collections.emptyList())
                .stream()
                .map(site -> emsDeviceService.getDeviceBySiteId(site.getId()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<EmsDevice> getDevicesBySite(String siteName) {
        return emsSiteService.getSiteByName(siteName)
                .map(site -> emsDeviceService.getDeviceBySiteId(site.getId()))
                .orElse(Collections.emptyList());
    }

    public List<Consumption> getConsumptionsByDevicesAndTimeRange(List<EmsDevice> devices, LocalDateTime start, LocalDateTime end) {
        return devices.stream()
                .map(EmsDevice::getId)
                .map(id -> consumptionRepository.findByDeviceIdAndRecordedTimeBetween(id, start, end))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<Consumption> getConsumptionList(List<EmsDevice> emsDevices) {
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
