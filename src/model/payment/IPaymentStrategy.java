package model.payment;

public interface IPaymentStrategy {
    void collectPaymentDetails();
    void processPayment(double amount);
    boolean validatePayment();
}

