package org.example.model.cartModels;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class SubCategory {
    String subCategoryId;
    String subCategoryName;
    List<Product> products;
    Double price; // products of same price in subCategory ; // Eg: Category : Cold Drinks , SubCategory : "001, blackpepsi, 100Rs" ,Product: xbpepsi_1,2024_01_01

    public List<Product> removeItems(int quantity) {
        List<Product> itemsTakenOff = products.subList(0, quantity);
        List<Product> clonedItems = new ArrayList<>();
        for (Product product : itemsTakenOff) {
            try {
                Product clone = (Product) product.clone();
                clonedItems.add(clone);
            } catch (CloneNotSupportedException e) {
                System.out.println("ERROR in cloning forSubCategory");
            }
        }


        return clonedItems;
    }
}
