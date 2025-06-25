package org.example.paymentservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO {
    private Long id;
    private Long userId;
    private Long bookingId;
    private double amount;
    private String cardNumber;
    private String transactionStatus;
    private String transactionTime;
    private String receiptUrl;
}
