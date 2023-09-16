package com.durys.jakub.paymentservice.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Payment(String type, LocalDate at, BigDecimal amount) {}
