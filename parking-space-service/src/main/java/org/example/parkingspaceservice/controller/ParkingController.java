package org.example.parkingspaceservice.controller;

import org.example.parkingspaceservice.dto.ParkingSpaceDTO;
import org.example.parkingspaceservice.dto.ResponseDTO;
import org.example.parkingspaceservice.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking")
@CrossOrigin(origins = "*")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;


    // "localhost:8087/api/parking/save" for save parking space
    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> addParking(@RequestBody ParkingSpaceDTO parkingSpaceDTO) {
        try {
            parkingService.createParkingSpace(parkingSpaceDTO);
            return ResponseEntity.ok(new ResponseDTO("success", "Parking space added successfully"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponseDTO("error", e.getMessage()));
        }
    }


    // "localhost:8087/api/parking/allSpaces" for getting all available parkings
    @GetMapping("/allSpaces")
    public ResponseEntity<List<ParkingSpaceDTO>> getAllSpaces() {
        try {
            return ResponseEntity.ok(parkingService.getAllSpaces());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }


    // "localhost:8087/api/parking/update/{id}" for update parking space by id
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateParking(@PathVariable Long id, @RequestBody ParkingSpaceDTO parkingSpaceDTO) {
        try {
            parkingService.updateParkingSpace(id, parkingSpaceDTO);
            return ResponseEntity.ok(new ResponseDTO("success", "Parking space updated successfully"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponseDTO("error", e.getMessage()));
        }
    }


    // "localhost:8087/api/parking/delete/{id}" for delete parking space by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteParking(@PathVariable Long id) {
        try {
            parkingService.deleteParkingSpace(id);
            return ResponseEntity.ok(new ResponseDTO("success", "Parking space deleted successfully"));
        } catch (Exception e) {

            return ResponseEntity.badRequest().body(new ResponseDTO("error", e.getMessage()));}
    }

}
