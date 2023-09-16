package com.durys.jakub.paymentservice.application;

import com.durys.jakub.paymentservice.domain.Payment;
import com.durys.jakub.paymentservice.domain.User;
import com.durys.jakub.paymentservice.domain.UserPaymentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PaymentApplicationService {

    private final UserPaymentsRepository repository;

    public List<Payment> userPayments(Long userId, LocalDate from, LocalDate to) {

       return repository.findById(userId)
                .map(User::getPayments)
                    .stream()
                    .flatMap(Collection::stream)
                    .filter(payment -> !payment.at().isAfter(to) && !payment.at().isBefore(from))
                    .toList();
    }
}
