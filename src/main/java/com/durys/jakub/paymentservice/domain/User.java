package com.durys.jakub.paymentservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document
public class User {
    @Id
    private Long userId;
    private Set<Payment> payments;
}
