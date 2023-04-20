package com.example.inherited;

import com.example.base.ClientImpl;

import java.util.Comparator;

public class VipClientImpl extends ClientImpl implements VipClient, Comparable<VipClientImpl>{

    private double interest;
    private double bonus;

    public VipClientImpl(String personalCode, int age, String currency, double amount, double interest, double bonus) {
        super(personalCode, age, currency, amount);
        this.interest = interest;
        this.bonus = bonus;
    }

    public VipClientImpl(double interest, double bonus) {
        this.interest = interest;
        this.bonus = bonus;
    }

    @Override
    public double getInterest() {
        return this.interest;
    }

    @Override
    public void setInterest(double interest) {
        this.interest = interest;
    }

    @Override
    public double getBonus() {
        return this.bonus;
    }

    @Override
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.toString() +
                " " +
                "interest=" + interest +
                ", bonus=" + bonus;
    }

    @Override
    public int compareTo(VipClientImpl vipClient) {
        return Comparator
                .comparing(VipClientImpl::getAmount)
                .reversed()
                .thenComparing(VipClientImpl::getAge)
                .compare(this, vipClient);
    }
}
