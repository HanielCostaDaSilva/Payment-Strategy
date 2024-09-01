package model.payment;

public class CreditCardPayment implements IPaymentStrategy {
    private String cardNumber;
    private String expirationDate;
    private String securityCode;

    public CreditCardPayment(String cardNumber, String expirationDate, String securityCode) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }

    public CreditCardPayment() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void collectPaymentDetails() {

        if (validatePayment()) {
            System.out.println("Validação do cartão de crédito bem-sucedida.");
        } else {
            System.out.println("Falha na validação do cartão de crédito.");
        }
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processamento o pagamento no valor de " + amount + " via Cartão de Crédito.");

    }

    public boolean validatePayment() {

        return cardNumber.length() == 16 && expirationDate.matches("\\d{2}/\\d{2}") && securityCode.length() == 3;
    }
}
