package com.aquent.entity;

public class Order implements Comparable<Order> {

    private String itemName;
    private Long orderTime;

    public Order(String itemName, Long orderTime) {
        this.itemName = itemName;
        this.orderTime = orderTime;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }

    public int compareTo(Order order) {
        int result = this.itemName.compareTo(order.getItemName());
        if (result == 0) {
            result = this.orderTime.compareTo(order.getOrderTime());
        }
        return result;
    }
}
