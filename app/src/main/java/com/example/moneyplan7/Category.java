package com.example.moneyplan7;

public class Category {
    private String color;
    private String name;
    private String money;
    boolean expense;

    public Category(String color, String name, String money, boolean expense) {
        this.color = color;
        this.name = name;
        this.money = money;
        this.expense = expense;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public boolean isExpense() {
        return expense;
    }

    public void setExpense(boolean expense) {
        this.expense = expense;
    }
}