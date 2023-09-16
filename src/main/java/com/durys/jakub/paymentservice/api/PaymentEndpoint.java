package com.durys.jakub.paymentservice.api;

import com.durys.jakub.paymentservice.application.PaymentApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.webservicesoap.payments.GetPaymentRequest;
import org.webservicesoap.payments.GetPaymentResponse;
import org.webservicesoap.payments.Payment;

import java.util.List;

import static com.durys.jakub.paymentservice.api.XmlConversionUtils.to;

@Endpoint
@RequiredArgsConstructor
public class PaymentEndpoint {

    private final PaymentApplicationService paymentService;

    @PayloadRoot(localPart = "getPaymentRequest", namespace = "http://www.webservicesoap.org/payments")
    @ResponsePayload
    public GetPaymentResponse payments(@RequestPayload GetPaymentRequest request) {

        List<Payment> payments = paymentService.userPayments((long) request.getUserId(),
                        to(request.getFrom()), to(request.getTo()))
                .stream()
                .map(payment -> new Payment(payment.amount(), payment.type()))
                .toList();

        return new GetPaymentResponse(payments);
    }

}
