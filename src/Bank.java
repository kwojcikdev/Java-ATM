import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public String getNewUserUUID()
    {
        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique;

        do {
            uuid="";
            for(int i=0; i<len; i++)
            {
                uuid += ((Integer)rng.nextInt(10)).toString();
            }


            nonUnique = false;
            for(User u : this.users)
            {
                if(uuid.compareTo(u.getUUID()) == 0) {nonUnique = true; break;}
            }
        }while (nonUnique);

        return uuid;
    }

    public String getNewAccountUUID()
    {
        String uuid;
        Random rng = new Random();
        int len = 8;
        boolean nonUnique;

        do {
            uuid="";
            for(int i=0; i<len; i++)
            {
                uuid += ((Integer)rng.nextInt(10)).toString();
            }


            nonUnique = false;
            for(Account a : this.accounts)
            {
                if(uuid.compareTo(a.getUUID()) == 0) {nonUnique = true; break;}
            }
        }while (nonUnique);


        return uuid;
    }



    public User addUser(String firstName, String lastName, String pin)
    {
        User newUser = new User(firstName, lastName, pin, this);

        this.users.add(newUser);

        Account newAccount = new Account("Savings", newUser, this);

        newUser.addAccount(newAccount);
        this.accounts.add(newAccount);

        return newUser;
    }

    public User userLogin(String userID, String pin)
    {
        for( User u : this.users)
        {
            if(u.getUUID().compareTo(userID) == 0)
            {
                if(u.validatePIN(pin)) return u;
            }
        }
        return null;
    }
}
