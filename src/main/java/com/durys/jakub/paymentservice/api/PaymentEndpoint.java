package com.durys.jakub.paymentservice.api;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.webservicesoap.payments.GetPaymentRequest;
import org.webservicesoap.payments.GetPaymentResponse;
import org.webservicesoap.payments.Payment;

import java.math.BigDecimal;
import java.util.Collections;

@Endpoint
public class PaymentEndpoint {

    @PayloadRoot(localPart = "getPaymentRequest", namespace = "http://www.webservicesoap.org/payments")
    @ResponsePayload
    public GetPaymentResponse payments(@RequestPayload GetPaymentRequest request) {
        var response = new GetPaymentResponse(
                Collections.singletonList(new Payment(BigDecimal.valueOf(1000), "Payment 1")));
        return response;
    }

}
