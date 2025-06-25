package org.example.paymentservice.service;

import org.example.paymentservice.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    PaymentDTO processPayment(PaymentDTO paymentDTO);

    List<PaymentDTO> getAllPayments();

    PaymentDTO getPaymentById(Long id);
}
