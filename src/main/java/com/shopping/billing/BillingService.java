package com.shopping.billing;

import com.shopping.cart.Cart;

public interface BillingService {
    void generateBill(Cart cart, OutputWriter outputWriter);
}
