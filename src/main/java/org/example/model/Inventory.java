package org.example.model;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.example.model.cartModels.Category;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class Inventory {
    List<Category> categories; // products inside categories only;

    public List<String> showCategoriesNames() {
        List<String> categoryNames = CollectionUtils.emptyIfNull(categories).stream().map(category -> category.getCategoryName()).collect(Collectors.toList());
        return categoryNames;
    }

    public List<String> products(String categoryId) {
        List<String> productNames = CollectionUtils.emptyIfNull(categories).stream()
                .filter(category -> categoryId.equals(category.getCategoryId()))
                .map(category -> CollectionUtils.emptyIfNull(category.getSubCategories())).flatMap(s -> s.stream()).map(subCategory -> subCategory.getSubCategoryName()).collect(Collectors.toList());
        return productNames;
    }


}
