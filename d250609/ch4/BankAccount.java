package d250609.ch4;

public class BankAccount {
    private String owner;

    private static int accountCount = 0;
    private static final double INTEREST_RATE = 0.02;

    public BankAccount(String owner) {
        this.owner = owner;
        accountCount++;
    }

    public void showInfo() {
        System.out.println("소유자: " + owner);
        System.out.println("현재 총 계좌 건수: " + accountCount);
        System.out.println("이자율: " + INTEREST_RATE);
    }
}
