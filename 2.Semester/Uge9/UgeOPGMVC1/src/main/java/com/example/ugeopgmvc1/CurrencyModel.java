package com.example.ugeopgmvc1;

public class CurrencyModel {
    private double usdRate = 737.14;
    private double gbpRate = 1179.14;
    private double yenRate = 7.2120;
    private double euroRate = 743.92;

    private double amountInDKK;

    public void setAmountInDKK(double amountInDKK) {
        this.amountInDKK = amountInDKK;
    }

    public double getAmountInUSD() {
        return (amountInDKK / usdRate) * 100;
    }

    public double getAmountInGBP() {
        return (amountInDKK / gbpRate) * 100;
    }

    public double getAmountInYEN() {
        return (amountInDKK / yenRate) * 100;
    }

    public double getAmountInEURO() {
        return (amountInDKK / euroRate) * 100;
    }
}