import java.util.ArrayList;
import java.util.List;

class Account {
    private int Ac;
    private String Name;
    private int Amount;

    public Account(int ac, String name, int amount) {
        Ac = ac;
        Name = name;
        Amount = amount;
    }

    public int getAc() {
        return Ac;
    }

    public void setAc(int ac) {
        Ac = ac;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String toString() {
        return "Account Ac=" + Ac + ", Name=" + Name + ", Amount=" + Amount;
    }
}

class Banker {
    ArrayList<Account> bank = new ArrayList<Account>();

    private static Banker obj = null;

    private Banker() {
        System.out.println("Object is created");
    }

    public static Banker getinstance() {
        if (obj == null) {
            obj = new Banker();
        }
        return obj;
    }
}

public class SingletonExp {
    public static void main(String[] args) {
        Account obj1 = new Account(100, "Bhavya", 01015465);
        Account obj2 = new Account(30, "Nisarg", 5);
        Banker banker = Banker.getinstance();
        banker.bank.add(obj1);
        banker.bank.add(obj2);
        System.out.println(obj1);
        System.out.println(obj2);
    }
}
