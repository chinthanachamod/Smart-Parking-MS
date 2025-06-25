package org.example.vehicleservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private String status;
    private String message;
}
