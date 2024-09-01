package model.payment;


// Concrete Strategy for PayPal
public class PayPalPayment implements IPaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password){
        this.email = email;
        this.password = password;
    }

    public PayPalPayment() {
        //TODO Auto-generated constructor stub
    }

    @Override
    public void collectPaymentDetails() {

        if (validatePayment()) {
            System.out.println("Autenticação PayPal bem-sucedida.");
        } else {
            System.out.println("Falha na autenticação do PayPal.");
        }
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processando o pagamento de " + amount + " via PayPal.");
    }
    
    /**
     *A validação consistirar no email ser igual a senha
     */
    public boolean validatePayment() {
        return email.equals(password);
    }
}
