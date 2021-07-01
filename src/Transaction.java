import java.util.Date;

public class Transaction {

    private double amount;
    private Date timestamp;
    private String description;
    private Account account;


    public Transaction(double amount, Account account)
    {
        this.amount = amount;
        this.account = account;
        this.description = "";

        this.timestamp = new Date();

    }

    public Transaction(double amount, Account account, String description)
    {
        this(amount, account);

        this.description = description;
    }
}
