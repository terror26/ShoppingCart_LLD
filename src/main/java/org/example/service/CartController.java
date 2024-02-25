package org.example.service;

import lombok.Builder;
import lombok.Data;
import org.example.model.User;
import org.example.model.cartModels.Cart;
import org.example.model.cartModels.Product;
import org.example.model.cartModels.SubCategory;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CartController {

    public boolean addItem(User user, SubCategory subCategory, int quantity) {
        Cart cart = user.getCurrentCart();
        if (cart == null) {
            cart = Cart.builder().subCategories(new ArrayList<>()).totalPrice(0D).build();
            user.setCurrentCart(cart);
        }
        if (quantity > subCategory.getProducts().size()) { // more than warehouse items
            return false; // cant add
        }
        // reduce warehouse stock
        List<Product> products = subCategory.removeItems(quantity);
        Double price = subCategory.getPrice() * quantity;
        SubCategory cartSubCategory = SubCategory.builder().products(products).price(price).build();
        // added product to cart and prices changed
        cart.getSubCategories().add(cartSubCategory);
        cart.setTotalPrice(cart.getTotalPrice() + price);
        return true;
    }

}
