package org.example.parkingspaceservice.service;

import org.example.parkingspaceservice.dto.ParkingSpaceDTO;

import java.util.List;

public interface ParkingService {
    void createParkingSpace(ParkingSpaceDTO parkingSpaceDTO);

    List<ParkingSpaceDTO> getAllSpaces();

    void updateParkingSpace(Long id, ParkingSpaceDTO parkingSpaceDTO);

    void deleteParkingSpace(Long id);

}
