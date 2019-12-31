package com.example.myapplication.models.vendorModels;

class AccountNumber {

    boolean bankAccount;
    String _id;

    public AccountNumber(boolean bankAccount, String _id) {
        this.bankAccount = bankAccount;
        this._id = _id;
    }

    public AccountNumber() {
    }

    public boolean isBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(boolean bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}

