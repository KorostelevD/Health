package com.example.Health.data.services;

import com.example.Health.models.Payment;
import lombok.NonNull;

import java.util.Optional;

public interface PaymentService {
    Payment save(Payment payment);

    Optional<Payment> findById(@NonNull Integer id);
}
