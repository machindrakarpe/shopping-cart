package com.shopping.billing;

import com.shopping.cart.Cart;

import java.math.BigDecimal;

public class BillingServiceImpl implements BillingService {

    @Override
    public void generateBill(Cart cart, OutputWriter outputWriter) {

        StringBuilder receipt = new StringBuilder("Name \t  Quantity \tPrice\n");

        cart.getItems().forEach(i -> receipt.append(i.getName()).append("\t\t").append(i.getQuantity()).append("\t\t").append(i.getPrice()).append("\n"));
        receipt.append("----------------------------\n");
        BigDecimal totalPrice = cart.totalPrice();
        receipt.append("Total:\t\t\t\t").append(totalPrice).append("\n");
        outputWriter.write(receipt.toString());
    }
}
