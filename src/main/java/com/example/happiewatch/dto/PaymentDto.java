package com.example.happiewatch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentDto {

    private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;
}
