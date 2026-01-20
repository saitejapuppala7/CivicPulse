package com.smartcity.civicpulse.controller;

import com.smartcity.civicpulse.services.AnalyticsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@PreAuthorize("hasRole('ADMIN') or hasRole('OFFICER')")
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final AnalyticsService service;

    public AnalyticsController(AnalyticsService service) {
        this.service = service;
    }

    @GetMapping("/category")
    public Map<String, Long> categoryWise() {
        return service.getCategoryWise();
    }


     @GetMapping("/zone")
    public Map<String, Long> zoneWise() {
        return service.getZoneWise();
    }

    @GetMapping("/sla")
    public Map<String, Long> slaReport() {
        return service.getSlaReport();
    }


    @GetMapping("/red-zones")
    public List<Map<String, Object>> redZones() {
        return service.getRedZones();

    }


}
