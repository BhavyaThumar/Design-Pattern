import java.util.ArrayList;
import java.util.List;

class Address 
{
    private String city;
    private String socityName;

    public Address(String city, String socityName) 
    {
        this.city = city;
        this.socityName = socityName;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }

    public void setSocityName(String socityName) 
    {
        this.socityName = socityName;
    }

    public String getSocityName() 
    {
        return socityName;
    }
}

class Item 
{
    private String name;
    private int price;
}

class Order implements Cloneable {

    private int ordId;
    private long amount;
    protected Address ad;
    protected List<Item> ls = new ArrayList<Item>();

    public Order(int ordId, long am, Address a) {
        this.ordId = ordId;
        amount = am;
        ad = a;
    }

    public void setOrderAmount(long am) {
        amount = am;
    }

    public String toString() {
        return " Order details: " + ordId + " amount" + amount + " @ city: " + ad.getCity() + " and location: "+ ad.getSocityName();
    }

    public Order Clone() 
    {
        Order o = null;
        try 
        {
            o = (Order) super.clone();
            Address a = new Address(ad.getCity(), ad.getSocityName());
            o.ad = a;
        } 
        catch (CloneNotSupportedException e) 
        {
            System.out.println(e);
        }

        return o;
    }
}

class orderdeepcopy 
{
    public static void main(String[] args) throws CloneNotSupportedException {

        Address a1 = new Address("Gandhinagar", "Nikol");
        Order o1 = new Order(101, 2000, a1);
        Order o2 = o1.Clone();
        System.out.println("Original order:" + o1);
        System.out.println("Cloned order:" + o2);

        o2.setOrderAmount(5000);
        o2.ad.setCity("Ahmedabad");   
        System.out.println("Original order" + o1);
        System.out.println("Cloned order" + o2);

    }
}