package nicebank;

public class Account {
    private Money balance = new Money();

    public void deposit(Money amount) {
        balance = balance.add(amount);
    }

    public void debit(int dollars) {
        balance = balance.minus(new Money(dollars, 0));
    }

    public Money getBalance() {
        return balance;
    }
}
