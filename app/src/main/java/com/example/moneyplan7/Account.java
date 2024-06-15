package com.example.moneyplan7;

public class Account {
    private String name;
    private boolean cashless; // true - безналичные, false - наличные
    private String drawableFileName;
    private String balance;
    private String color;

    public Account(String name, boolean cashless, int balance, String color) {
        this.name = name;
        this.cashless = cashless;
        this.balance = Integer.toString(balance);
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCashless() {
        return cashless;
    }

    public void setCashless(boolean cashless) {
        this.cashless = cashless;
    }

    public String getDrawableFileName() {
        return drawableFileName;
    }

    public void setDrawableFileName(String drawableFileName) {
        this.drawableFileName = drawableFileName;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = Integer.toString(balance);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
