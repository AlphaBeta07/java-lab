// SavingsAccount.java
public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double balance) {
        this.savingsBalance = balance;
    }
    public static void modifyInterestRate(double newRate) {
        annualInterestRate = newRate;
    }
    public void calculateMonthlyInterest() {
        double monthly = (savingsBalance * annualInterestRate) / 12.0;
        savingsBalance += monthly;
    }
    public double getBalance() { return savingsBalance; }
}

// TestSavings.java
public class TestSavings {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        SavingsAccount.modifyInterestRate(0.04); // 4%
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println("Balances after 4%:");
        System.out.println("Saver1: " + saver1.getBalance());
        System.out.println("Saver2: " + saver2.getBalance());

        SavingsAccount.modifyInterestRate(0.05); // 5%
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println("Balances after 5% next month:");
        System.out.println("Saver1: " + saver1.getBalance());
        System.out.println("Saver2: " + saver2.getBalance());
    }
}
