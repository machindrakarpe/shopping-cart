package com.shopping.billing;

import com.shopping.cart.Cart;
import com.shopping.cart.Item;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class BillingServiceImplTest {

    @Test
    void shouldPrintBill() {
        BillingService billingService = new BillingServiceImpl();
        Cart cart = createCartWithAnItemMilk();
        cart.add(new Item("Milk", BigDecimal.valueOf(2), 1));
        cart.add(new Item("Bread", BigDecimal.valueOf(3.5), 1));
        billingService.generateBill(cart);
    }

    private Cart createCartWithAnItemMilk() {
        Cart cart = new Cart();
        Item item = new Item("Milk", BigDecimal.valueOf(3), 1);
        cart.add(item);
        return cart;
    }
}