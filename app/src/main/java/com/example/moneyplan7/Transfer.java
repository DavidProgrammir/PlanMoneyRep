package com.example.moneyplan7;

public class Transfer {
    private String startTransfer;
    private String endTransfer;
    private boolean expense; //true - расход
    private String sum;
    private String date;

    public Transfer(String startTransfer, String endTransfer, boolean expense, String sum, String date) {
        this.startTransfer = startTransfer;
        this.endTransfer = endTransfer;
        this.expense = expense;
        this.sum = sum;
        this.date = date;
    }

    public String getStartTransfer() {
        return startTransfer;
    }

    public void setStartTransfer(String account) {
        this.startTransfer = startTransfer;
    }

    public String getEndTransfer() {
        return endTransfer;
    }

    public void setEndTransfer(String category) {
        this.endTransfer = endTransfer;
    }

    public boolean isExpense() {
        return expense;
    }

    public void setExpense(boolean expense) {
        this.expense = expense;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    //
    //
    //
    //



}
