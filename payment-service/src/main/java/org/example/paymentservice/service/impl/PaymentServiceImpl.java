package org.example.paymentservice.service.impl;

import org.example.paymentservice.dto.PaymentDTO;
import org.example.paymentservice.entity.Payment;
import org.example.paymentservice.repo.PaymentRepository;
import org.example.paymentservice.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PaymentDTO processPayment(PaymentDTO paymentDTO) {
        paymentDTO.setTransactionStatus("SUCCESS");
        paymentDTO.setTransactionTime(LocalDateTime.now().toString());
        paymentDTO.setReceiptUrl("https://mock-receipts.com/" + UUID.randomUUID());

        Payment payment = modelMapper.map(paymentDTO, Payment.class);

        Payment saved = paymentRepository.save(payment);
        return modelMapper.map(saved, PaymentDTO.class);
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream().map(payment -> modelMapper.map(payment, PaymentDTO.class)).toList();
    }

    @Override
    public PaymentDTO getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        return modelMapper.map(payment, PaymentDTO.class);
    }
}
