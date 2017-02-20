package com.example.sangeeth.assignment.data;

/**
 * Created by sangeeth on 25/1/17.
 */

public class Message {
    public BillingAddress[] getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress[] billingAddress) {
        this.billingAddress = billingAddress;
    }

    public BillingAddress[] getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(BillingAddress[] shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    private BillingAddress[] billingAddress;

    private  BillingAddress[] shippingAddress;
}
