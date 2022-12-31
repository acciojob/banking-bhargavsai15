package com.driver;

import java.util.Stack;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance);
        this.tradeLicenseId=tradeLicenseId;
        this.setMinBalance(5000);
        if(this.getBalance()<this.getMinBalance()){
            throw new Exception("Insufficient Balance");
        }
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        String S=this.tradeLicenseId;

        Stack<Character> s1=new Stack<>();
        s1.push(S.charAt(0));
        Stack<Character> s2=new Stack<>();

        for(int i=1;i<S.length();i++){
            char c=S.charAt(i);

            if(s1.peek()!=c){
                s1.push(c);
            }else{
                s2.push(c);
            }

            while(!s2.isEmpty() && !s1.isEmpty() && s1.peek()!=s2.peek()){
                s1.push(s2.pop());
            }
        }

        if(!s2.isEmpty()){
            throw new Exception("Valid License can not be generated");
        }
    }

}

