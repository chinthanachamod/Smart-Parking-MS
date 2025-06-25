package org.example.vehicleservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String plateNumber;

    private String brand;

    private String color;

    private String entryTime;

    private String exitTime;

    private Long userId;
}
