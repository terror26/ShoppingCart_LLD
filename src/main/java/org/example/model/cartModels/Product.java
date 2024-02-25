package org.example.model.cartModels;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product implements Cloneable {
    String id;
    String expiresOn;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
