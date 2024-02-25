package org.example;

import org.example.model.Inventory;
import org.example.model.User;
import org.example.model.cartModels.Category;
import org.example.model.cartModels.Product;
import org.example.model.cartModels.SubCategory;
import org.example.service.CartController;
import org.example.service.InventoryController;
import org.example.service.OrderController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Driver {
    public void initialize() {
        // make inventory with products;
        Inventory i1 = getInventory();
        InventoryController inventoryController = InventoryController.builder().cityVsInventory(new HashMap<>()).inventories(new ArrayList<>()).build();
        String city = "DELHI";
        inventoryController.addInventory(i1, city);


        User user = User.builder().id("Kanishk verma").build();
        System.out.println("Current Cart Items = " + user.getCurrentCart());
        System.out.println("Search inventory for DELHI");

        System.out.println("categories of selected Inventory = " + inventoryController.selectInventory(city).getCategories());

        Inventory selectedInventory = inventoryController.selectInventory(city);
        String selectedCategory = "Cold Drink";
        System.out.println("Products in category + " + selectedInventory.products(selectedCategory));

        List<SubCategory> subCategories = inventoryController.getSubcategories(selectedInventory, selectedCategory);
        int quantity = 3;
        SubCategory selectedSubCategory = subCategories.get(0);
        System.out.println("selected Subcategory = " + selectedSubCategory.getSubCategoryName() + " quantity = " + quantity);
        CartController cartController = CartController.builder().build();
        cartController.addItem(user, selectedSubCategory, 3);

        OrderController orderController = OrderController.builder().build();
        orderController.createOrder(user);

    }

    private static Inventory getInventory() {
        SubCategory s1 = SubCategory.builder().subCategoryId("LaysChips_001").subCategoryName("Lays Salted").price(10D).products(Arrays.asList(Product.builder().id("1").expiresOn("2023_01_01").build(), Product.builder().id("2").expiresOn("2023_03_01").build(), Product.builder().id("3").expiresOn("2025_03_01").build())).build();

        SubCategory s2 = SubCategory.builder().subCategoryId("LaysChips_002").subCategoryName("Lays Blue").price(10D).products(Arrays.asList(Product.builder().id("1").expiresOn("2023_01_01").build(), Product.builder().id("2").expiresOn("2023_03_01").build(), Product.builder().id("3").expiresOn("2025_03_01").build())).build();

        SubCategory s3 = SubCategory.builder().subCategoryId("Cold_Drink_001").subCategoryName("pepse_black").price(50D).products(Arrays.asList(Product.builder().id("1").expiresOn("2023_01_01").build(), Product.builder().id("2").expiresOn("2023_03_01").build(), Product.builder().id("3").expiresOn("2025_03_01").build())).build();


        SubCategory s4 = SubCategory.builder().subCategoryId("Cold_Drink_002").subCategoryName("miranda").price(10D).products(Arrays.asList(Product.builder().id("1").expiresOn("2023_01_01").build(), Product.builder().id("2").expiresOn("2023_03_01").build(), Product.builder().id("3").expiresOn("2025_03_01").build())).build();


        Category c1 = Category.builder().categoryId("Chips").categoryName("Chips").subCategories(Arrays.asList(s1, s2)).build();

        Category c2 = Category.builder().categoryId("Cold Drink").categoryName("Cold Drink").subCategories(Arrays.asList(s3, s4)).build();
        Inventory i1 = Inventory.builder().categories(Arrays.asList(c1, c2)).build();
        return i1;
    }

}
