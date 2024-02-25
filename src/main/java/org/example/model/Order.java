package org.example.model;


import lombok.Builder;
import lombok.Data;
import org.example.model.cartModels.Cart;

@Data
@Builder
public class Order {
    String orderId;
    String orderDate; // timestamp
    OrderStatus OrderStatus; // Created, In-transit, Delivered
    PaymentDetails paymentDetails;

    Cart items;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", OrderStatus=" + OrderStatus +
                ", paymentDetails=" + paymentDetails +
                ", items=" + items +
                '}';
    }
}
