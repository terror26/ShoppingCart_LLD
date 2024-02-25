package org.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentDetails {
    String paymentId;
    PaymentStatus paymentStatus;
    String paymentDate;
}
