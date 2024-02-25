package org.example.model;

import lombok.Builder;
import lombok.Data;
import org.example.model.cartModels.Cart;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class User{
    String id;
    Cart currentCart = null;
    List<String> orderId = new ArrayList<>();

}
