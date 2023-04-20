package com.example.base;
public class ClientImpl implements Client {
    private String personalCode;
    private int age;
    private String currency;
    private double amount;

    public ClientImpl(String personalCode, int age, String currency, double amount) {
        this.personalCode = personalCode;
        this.age = age;
        this.currency = currency;
        this.amount = amount;
    }

    public ClientImpl() {

    }

    @Override
    public String getPersonalCode() {
        return this.personalCode;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getCurrency() {
        return this.currency;
    }

    @Override
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Client: " +
                "personalCode='" + personalCode + '\'' +
                ", age=" + age +
                ", currency='" + currency + '\'' +
                ", amount=" + amount;
    }
}
