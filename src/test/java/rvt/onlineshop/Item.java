package rvt.onlineshop;

public class Item {
    private String product;
    private int quantity;
    private int unitPrice;

    public Item(String productName, int qty, int price) {
        product = productName;
        quantity = qty;
        unitPrice = price;
    }

    public int price() {
        return quantity * unitPrice;
    }

    public void increaseQuantity() {
        quantity++;
    }

    public String toString() {
        return product + ": " + quantity;
    }
}