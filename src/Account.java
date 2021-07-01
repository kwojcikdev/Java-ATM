import java.util.ArrayList;

public class Account {

    private String name;
    private String uuid;
    private User user;
    private ArrayList<Transaction> transactions;

    public Account(String name, User user, Bank bank)
    {
        this.name = name;
        this.user = user;

        //get uuid
        this.uuid = bank.getNewAccountUUID();

        this.transactions = new ArrayList<Transaction>();


    }

    public String getUUID(){
        return this.uuid;
    }


}
