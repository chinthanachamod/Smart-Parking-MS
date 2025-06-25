package org.example.vehicleservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    private Long id;
    private String type;
    private String plateNumber;
    private String brand;
    private String color;
    private String entryTime;
    private String exitTime;
    private Long userId;
}
