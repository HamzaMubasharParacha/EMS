package com.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.models.Consumption;
import com.models.EmsDevice;
import com.repositories.ConsumptionRepository;
import com.util.ConsumptionHelper;
import com.util.TimeRangeUtil;

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
    @Autowired
    private ConsumptionHelper consumptionHelper;

    public List<Consumption> getAllDevicesConsumption() {
        return consumptionRepository.findAll();
    }

    public List<Consumption> getRegionDevicesConsumption(String regionName) {
        return consumptionHelper.getConsumptionList(consumptionHelper.getDevicesByRegion(regionName));
    }

    public List<Consumption> getSiteDevicesConsumption(String siteName) {
        return consumptionHelper.getConsumptionList(consumptionHelper.getDevicesBySite(siteName));
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

    public List<Consumption> getTodayConsumptionByRegion(String regionName) {
        List<EmsDevice> devices = consumptionHelper.getDevicesByRegion(regionName);
        LocalDateTime[] range = TimeRangeUtil.getTodayRange();
        return consumptionHelper.getConsumptionsByDevicesAndTimeRange(devices, range[0], range[1]);
    }

    public List<Consumption> getThisMonthConsumptionByRegion(String regionName) {
        List<EmsDevice> devices = consumptionHelper.getDevicesByRegion(regionName);
        LocalDateTime[] range = TimeRangeUtil.getThisMonthRange();
        return consumptionHelper.getConsumptionsByDevicesAndTimeRange(devices, range[0], range[1]);
    }

    public List<Consumption> getConsumptionByRegionAndMonth(String regionName, int year, int month) {
        List<EmsDevice> devices = consumptionHelper.getDevicesByRegion(regionName);
        LocalDateTime[] range = TimeRangeUtil.getMonthRange(year, month);
        return consumptionHelper.getConsumptionsByDevicesAndTimeRange(devices, range[0], range[1]);
    }

    public List<Consumption> getTodayConsumptionBySite(String siteName) {
        List<EmsDevice> devices = consumptionHelper.getDevicesBySite(siteName);
        LocalDateTime[] range = TimeRangeUtil.getTodayRange();
        return consumptionHelper.getConsumptionsByDevicesAndTimeRange(devices, range[0], range[1]);
    }

    public List<Consumption> getThisMonthConsumptionBySite(String siteName) {
        List<EmsDevice> devices = consumptionHelper.getDevicesBySite(siteName);
        LocalDateTime[] range = TimeRangeUtil.getThisMonthRange();
        return consumptionHelper.getConsumptionsByDevicesAndTimeRange(devices, range[0], range[1]);
    }

    public List<Consumption> getConsumptionBySiteAndMonth(String siteName, int year, int month) {
        List<EmsDevice> devices = consumptionHelper.getDevicesBySite(siteName);
        LocalDateTime[] range = TimeRangeUtil.getMonthRange(year, month);
        return consumptionHelper.getConsumptionsByDevicesAndTimeRange(devices, range[0], range[1]);
    }
}
