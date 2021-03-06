package com.shopping.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {

    private final List<Item> items = new ArrayList<>();

    public Cart() {
    }

    public List<Item> getItems() {
        return items;
    }

    public void add(Item item) {
        Optional<Item> existingItem = items.stream()
                .filter(i -> i.getName().equals(item.getName()))
                .findFirst();

        if (!existingItem.isPresent()) {
            items.add(item);
            return;
        }
        existingItem.ifPresent(i -> i.setQuantity(i.getQuantity() + item.getQuantity()));
    }

    public void remove(Item item) {
        items.removeIf(i -> i.getName().equals(item.getName()));
    }

    public BigDecimal totalPrice() {
        return items.stream()
                .map(this::costPerItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal costPerItem(Item item) {
        return item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
    }
}
