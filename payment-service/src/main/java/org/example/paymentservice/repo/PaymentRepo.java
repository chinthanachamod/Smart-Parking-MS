package org.example.paymentservice.repo;

import org.example.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface PaymentRepo extends JpaRepository<Payment, UUID> {
    List<Payment> findAllByUserEmail(String email);
}
