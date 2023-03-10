package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;


    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance);
        super.setMinBalance(0);
        this.maxWithdrawalLimit=maxWithdrawalLimit;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

        if(amount>this.maxWithdrawalLimit){
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        else if(amount>this.getBalance()){
            throw new Exception("Insufficient Balance");
        }

        double bal=this.getBalance()-amount;
        this.setBalance(bal);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount

        //rate,balance,time
        double P=this.getBalance();

        return (P*rate*years)/100;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double principle=this.getBalance();
        double CI=0;
        for(int i=0;i<times;i++){
            CI+=principle * (Math.pow((1 + rate / 100), years)) - principle;
        }
        return CI;
    }

}
