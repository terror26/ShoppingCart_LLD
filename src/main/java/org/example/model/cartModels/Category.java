package org.example.model.cartModels;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Category {
    List<SubCategory> subCategories;
    String categoryId;
    String categoryName;

    @Override
    public String toString() {
        return "Category -> " +
                ", categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'';
    }
}
