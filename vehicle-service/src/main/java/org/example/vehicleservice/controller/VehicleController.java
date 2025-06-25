package org.example.vehicleservice.controller;

import org.example.vehicleservice.dto.ResponseDTO;
import org.example.vehicleservice.dto.VehicleDTO;
import org.example.vehicleservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
@CrossOrigin(origins = "*")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        try {
            vehicleService.saveVehicle(vehicleDTO);
            return ResponseEntity.ok(new ResponseDTO("success", "Vehicle saved successfully"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponseDTO("error", e.getMessage()));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateVehicle(@PathVariable Long id) {
        try {
            vehicleService.updateVehicle(id);
            return ResponseEntity.ok(new ResponseDTO("success", "Vehicle updated successfully"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseDTO("error", e.getMessage()));
        }
    }

    @GetMapping("/allVehicles")
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        try {
            return ResponseEntity.ok(vehicleService.getAllVehicles());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteVehicle(@PathVariable Long id) {
        try {
            vehicleService.deleteVehicle(id);
            return ResponseEntity.ok(new ResponseDTO("success", "Vehicle deleted successfully"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseDTO("error", e.getMessage()));
        }
    }
}
