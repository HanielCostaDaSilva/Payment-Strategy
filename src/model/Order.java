package model;

import model.payment.IPaymentStrategy;

public class Order {
    private double totalAmount;
    private IPaymentStrategy paymentStrategy;

    public Order(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setPaymentStrategy(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processOrder() {
        paymentStrategy.collectPaymentDetails();
        paymentStrategy.processPayment(totalAmount);
    }
}
