package com.example.happiewatch.api;

import com.example.happiewatch.dto.PaymentDto;
import com.example.happiewatch.service.PaypalService;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PaypalController {

    @Autowired
    PaypalService service;

    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "payment";


    @PostMapping("/pay")
    public Object payment(@RequestBody PaymentDto paymentDto) {
        try {
            Payment payment = service.createPayment(paymentDto.getPrice(), paymentDto.getCurrency(), paymentDto.getMethod(),
                    paymentDto.getIntent(), paymentDto.getDescription(), "http://localhost:3000/" + CANCEL_URL,
                    "http://localhost:3000/" + SUCCESS_URL);
            return payment.getLinks();
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "fall";
    }


}
