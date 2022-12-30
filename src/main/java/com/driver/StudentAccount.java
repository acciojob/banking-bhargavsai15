package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public StudentAccount(String name, double balance, String  institutionName) {
        //minimum balance is 0 by default
        super(name,balance);
        this.institutionName=institutionName;
        this.setMinBalance(0);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public double getMinBalance() {
        return super.getMinBalance();
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
}
