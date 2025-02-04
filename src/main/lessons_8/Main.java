package main.lessons_8;
import java.util.Scanner;
public class Main {
    static double balance;

    public static void main(String[] args) {
        balance = getBalance();
        balance = validateAmount(balance, getAmount());
    }

    private static double getBalance() {
        return 1000.00;
    }

    private static double getAmount() {
        System.out.printf("Balance is USD %.2f.%n" +
                "Enter purchase amount, USD: ", balance);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();

    }

    // Метод валідації наявних коштів
    private static double validateAmount (double balance, double withdrawal)  {
        if (withdrawal > balance) {

            try {
                throw new FundsException ("Insufficient funds!");
            } catch (FundsException ex ) {
                System.out.println(ex.getMessage());
            }
        } else {
            balance = getBalance(balance, withdrawal);
            System.out.printf("Funds are OK. Purchase paid." +
                    "%nBalance is USD %.2f", balance);
        }
        return balance;
    }

    private static double getBalance(double balance, double withdrawal) {
        return balance - withdrawal ;
    }
}
