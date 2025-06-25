package org.example.vehicleservice.service;

import org.example.vehicleservice.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    int saveVehicle(VehicleDTO vehicle);

    int updateVehicle(VehicleDTO vehicleDTO);

    int deleteVehicle(VehicleDTO vehicleDTO);

    List<VehicleDTO> getAllVehicle();

    VehicleDTO getVehicleByNumberPlate(String licenPlate);
}
