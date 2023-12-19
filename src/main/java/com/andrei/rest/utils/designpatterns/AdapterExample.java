package com.andrei.rest.utils.designpatterns;

public class AdapterExample {
}

//third-party library interface, which is incompatible with our system
interface AdvancedPaymentGateway {

    void makePayment(String mobile1, String mobile2);
}

//adapter interface compatible with our system
interface PaymentGateway {

    void makePayment(String mobile1, String mobile2);
}


class PaymentGatewayAdapter implements PaymentGateway {

    private AdvancedPaymentGateway advancedPaymentGateway;

    public PaymentGatewayAdapter(AdvancedPaymentGateway advancedPaymentGateway) {
        this.advancedPaymentGateway = advancedPaymentGateway;
    }

    @Override
    public void makePayment(String account1, String account2) {
        advancedPaymentGateway.makePayment(account1, account2);
    }
}