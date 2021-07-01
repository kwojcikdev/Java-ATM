import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {

    private String firstName;
    private String lastName;
    private String uuid;
    private byte pinHash[];
    private ArrayList<Account> accounts;


    public User(String firstName, String lastName, String pin, Bank bank)
    {
        this.firstName = firstName;
        this.lastName = lastName;

        //hash the pin
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // get new unique ID
        this.uuid = bank.getNewUserUUID();

        this.accounts = new ArrayList<Account>();



        System.out.println("New user " + this.firstName + " " + this.lastName + " with ID " + this.uuid + " created");

    }

    public void addAccount(Account account)
    {
        this.accounts.add(account);
        System.out.println("Added account: " + account);
    }

    public String getUUID(){
        return this.uuid;
    }
}
