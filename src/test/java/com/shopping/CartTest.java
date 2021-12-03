package com.shopping;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void shouldCreateEmptyCart(){
        Cart cart = new Cart();

        assertEquals(0, cart.getItems().size());
    }

    @Test
    void shouldAddOneItemToCart() {
        Cart cart = createCartWithAnItemMilk();
        List<Item> items = cart.getItems();

        assertEquals(1, items.size());
    }

    @Test
    void shouldAddMultipleItemsToCart() {
        Cart cart = createCartWithAnItemMilk();
        Item egg = new Item("Egg", BigDecimal.valueOf(2), 2);
        cart.add(egg);
        List<Item> items = cart.getItems();

        assertEquals(2, items.size());
    }

    @Test
    void shouldUpdateQuantityWhenItemAlreadyInCart() {
        Cart cart = createCartWithAnItemMilk();
        Item milk = new Item("Milk", BigDecimal.valueOf(2), 2);
        cart.add(milk);
        List<Item> items = cart.getItems();
        Item updatedCartItem = cart.getItems().get(0);

        assertEquals(1, items.size());
        assertEquals(3, updatedCartItem.getQuantity());
        assertEquals("Milk", updatedCartItem.getName());
    }

    @Test
    void shouldRemoveExistingItemFromCart() {
        Cart cart = createCartWithAnItemMilk();
        Item item = new Item("Milk", BigDecimal.valueOf(3), 1);
        cart.remove(item);
        List<Item> items = cart.getItems();

        assertEquals(0, items.size());
    }

    @Test
    void shouldNotRemoveItemThatIsNotInCart() {
        Cart cart = createCartWithAnItemMilk();
        Item item = new Item("Sugar", BigDecimal.valueOf(4), 1);
        cart.remove(item);
        List<Item> items = cart.getItems();

        assertEquals(1, items.size());
    }

    @Test
    void shouldTotalPriceFiveForTwoCartItemsWithPriceTreeAndTwo() {
        Cart cart = createCartWithAnItemMilk();
        Item milk = new Item("Cake", BigDecimal.valueOf(2), 1);
        cart.add(milk);

        assertEquals(BigDecimal.valueOf(5), cart.totalPrice());
    }

    @Test
    void shouldTotalPriceEightForTwoCartItemsWithPriceTreeAndFive() {
        Cart cart = createCartWithAnItemMilk();
        Item milk = new Item("Cake", BigDecimal.valueOf(5), 1);
        cart.add(milk);

        assertEquals(BigDecimal.valueOf(8), cart.totalPrice());
    }

    @Test
    void shouldTotalPriceThirteenForMoreThanOneQuantities() {
        Cart cart = createCartWithAnItemMilk();
        Item cake = new Item("Cake", BigDecimal.valueOf(5), 2);
        cart.add(cake);

        assertEquals(BigDecimal.valueOf(13), cart.totalPrice());
    }

    @Test
    void shouldPrintCartDetails() {
        Cart cart = createCartWithAnItemMilk();
        cart.add(new Item("Milk", BigDecimal.valueOf(2), 1));
        cart.add(new Item("Bread", BigDecimal.valueOf(3.5), 1));
        cart.details();
    }

    private Cart createCartWithAnItemMilk() {
        Cart cart = new Cart();
        Item item = new Item("Milk", BigDecimal.valueOf(3), 1);
        cart.add(item);
        return cart;
    }
}