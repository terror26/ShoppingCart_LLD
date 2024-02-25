package org.example.service;

import lombok.Builder;
import lombok.Data;
import org.example.model.*;
import org.example.model.cartModels.Cart;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class OrderController {

    public Order createOrder(User user) {
        try {
            Order order = Order.builder()
                    .orderId(user.getId() + "_" + UUID.randomUUID())
                    .orderDate(LocalDate.now().toString()).OrderStatus(OrderStatus.CREATED)
                    .paymentDetails(PaymentDetails.builder().paymentStatus(PaymentStatus.SUCCESSFUL).build())
                    .items((Cart) user.getCurrentCart().clone()).build();
            System.out.println("Order created  = " + order.toString());
            return order;
        } catch (CloneNotSupportedException e) {
            System.out.println("ERROR in cloning for OrderController");
            return null;
        }
    }




}
