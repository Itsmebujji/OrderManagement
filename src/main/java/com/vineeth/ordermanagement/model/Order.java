package com.vineeth.ordermanagement.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity(name="order")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int orderId;
    private String itemId;
    private String itemName;
    private String customerId;
    private String customerName;
    private int itemQuantity;
    private int itemPrice;
    private long totalPrice;
}
