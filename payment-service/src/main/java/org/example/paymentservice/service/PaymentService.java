package org.example.paymentservice.service;

import org.example.paymentservice.dto.PaymentDTO;
import org.example.paymentservice.dto.ResponseDTO;

import java.util.List;

public interface PaymentService {
    ResponseDTO savePaymentAndTransaction(PaymentDTO paymentDTO);

    List<PaymentDTO> getAllPayments();

    List<PaymentDTO> getAllPaymentBYEmail(String email);
}
