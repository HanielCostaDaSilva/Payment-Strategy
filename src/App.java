import java.util.Scanner;

import model.Order;
import model.payment.*;

public class App {

    public static void main(String[] args) {
        Order order = new Order(150.0); // Valor total do pedido

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Escolha o método de pagamento:");
            System.out.println("1. PayPal");
            System.out.println("2. Cartão de Crédito");
            System.out.print("=> ");
            int choice = scanner.nextInt();

            IPaymentStrategy paymentStrategy;

            switch (choice) {
                case 1:
                    System.out.print("Informe o email => ");
                    String email = scanner.next();

                    System.out.print("Informe a senha => ");
                    String password = scanner.next();

                    paymentStrategy = new PayPalPayment(email, password);
                    break;
                case 2:
                    System.out.print("Informe o numero do cartão =>");
                    String number = scanner.next();

                    System.out.print("Informe a Data De Inspiração =>");
                    String date = scanner.next();

                    System.out.print("Informe o codigo de segurança =>");
                    String securityCode = scanner.next();

                    paymentStrategy = new CreditCardPayment(number, date, securityCode);
                    break;
                default:
                    System.out.println("Escolha inválida.");
                    return;
            }

            order.setPaymentStrategy(paymentStrategy);
        }
        order.processOrder();
    }
}
