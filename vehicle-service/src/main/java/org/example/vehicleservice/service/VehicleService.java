package org.example.vehicleservice.service;

import org.example.vehicleservice.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);

    void updateVehicle(Long id);

    List<VehicleDTO> getAllVehicles();

    void deleteVehicle(Long id);
}
