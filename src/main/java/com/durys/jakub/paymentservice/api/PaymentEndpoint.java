package com.durys.jakub.paymentservice.api;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.webservicesoap.payments.GetPaymentRequest;
import org.webservicesoap.payments.GetPaymentResponse;

import java.math.BigDecimal;

@Endpoint
public class PaymentEndpoint {

    @PayloadRoot(localPart = "getPaymentRequest", namespace = "http://www.webservicesoap.org/payments")
    @ResponsePayload
    public GetPaymentResponse payments(GetPaymentRequest request) {
        var response = new GetPaymentResponse();
        response.setAmount(BigDecimal.valueOf(1000));
        response.setType("Payment 1");
        return response;
    }

}