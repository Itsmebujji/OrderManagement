package com.vineeth.ordermanagement.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    private int orderId;
    private String itemId;
    private String itemName;
    private String customerId;
    private String customerName;
    private int itemQuantity;
    private int itemPrice;
    private long totalPrice;
}
