package org.example.model.cartModels;

import lombok.Builder;
import lombok.Data;
import org.example.model.cartModels.SubCategory;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Cart implements Cloneable {
    List<SubCategory> subCategories;
    Double totalPrice = 0D;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
