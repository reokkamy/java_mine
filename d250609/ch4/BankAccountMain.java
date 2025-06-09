package d250609.ch4;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("김무진");
        BankAccount account2 = new BankAccount("이순신");
        BankAccount account3 = new BankAccount("홍길동");

        BankAccount[] showAccounts = { account1, account2, account3 };
        for (BankAccount account : showAccounts) {
            account.showInfo();
        }
    }
}
