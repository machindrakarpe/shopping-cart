package com.shopping.billing;

import com.shopping.cart.Cart;
import com.shopping.cart.Item;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;

class BillingServiceImplTest {

    public static final String RECEIPT =
            "Name \t  Quantity \tPrice\n" +
            "Milk\t\t2\t\t3\n" +
            "Bread\t\t1\t\t3.5\n" +
            "----------------------------\n" +
            "Total:\t\t\t\t9.5\n";

    @Test
    void shouldPrintBill() {
        BillingService billingService = new BillingServiceImpl();
        Cart cart = createCartWithAnItemMilk();
        cart.add(new Item("Milk", BigDecimal.valueOf(2), 1));
        cart.add(new Item("Bread", BigDecimal.valueOf(3.5), 1));
        OutputWriter mockWriter = Mockito.mock(OutputWriter.class);
        billingService.generateBill(cart, mockWriter);

        verify(mockWriter).write(RECEIPT);
    }

    private Cart createCartWithAnItemMilk() {
        Cart cart = new Cart();
        Item item = new Item("Milk", BigDecimal.valueOf(3), 1);
        cart.add(item);
        return cart;
    }
}