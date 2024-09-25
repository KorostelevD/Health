package com.example.Health.data.services.db;


import com.example.Health.data.repositories.PaymentRepository;
import com.example.Health.data.services.PaymentService;
import com.example.Health.models.Payment;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceDb implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Optional<Payment> findById(@NonNull Integer id) {
        Optional<Payment> optional = paymentRepository.findById(id);
        //--
        if (optional.isEmpty()){
            System.err.println("Optional Empty");
        }
        return optional;
    }
}
