package org.example.service;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.example.model.Inventory;
import org.example.model.cartModels.SubCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class InventoryController {
    List<Inventory> inventories; // inventories list or warehouses

    Map<String, Inventory> cityVsInventory;

    public void addInventory(Inventory inventory, String city) {
        cityVsInventory.put(city, inventory);
        inventories.add(inventory);
    }

    public Inventory selectInventory(String city) { // can be made via a strategy pattern
        return cityVsInventory.get(city);
    }

    public List<SubCategory> getSubcategories(Inventory selectedInventory, String selectedCategory) {
        Optional<List<SubCategory>> subCategories = CollectionUtils.emptyIfNull(
                selectedInventory.getCategories()).stream()
                .filter(category -> category.getCategoryName().equals(selectedCategory))
                .findFirst().map(category -> category.getSubCategories());
        return subCategories.isPresent() ? subCategories.get() : null;
    }
}
