import java.util.*;

public class Billing {
    public static void main(String[] args) {
        Shop s = new Shop("Soap", 12);

        Product[] array = new Product[] {
                new NewProduct(1000, ",flefef,"),
                new NewProduct(100, ",Soap,"),
        };

        s.addProducts(array);
        s.listProducts();

    }

}

class Shop {
    String S_Name;
    int S_ID;
    private Set<Product> products = new TreeSet<Product>();

    Shop(String S_name, int S_ID) {
        this.S_Name = S_Name;
        this.S_ID = S_ID;
    }

    public String getS_Name() {
        return S_Name;
    }

    public void setS_Name(String s_Name) {
        S_Name = s_Name;
    }

    public int getS_ID() {
        return S_ID;
    }

    public void setS_ID(int s_ID) {
        S_ID = s_ID;
    }

    Shop(Set<Product> products, String S_Name) {
        this.products = products;
        this.S_Name = S_Name;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void addProducts(Product products[]) {
        this.products.addAll(Arrays.asList(products));
    }

    public void listProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

abstract class Product implements Comparable {
    private static int count = 0;
    protected int ID, Price;
    protected String P_Name;

    {
        ID = count;
        count++;
    }

    Product(int Price, String P_Name) {
        this.Price = Price;
        this.P_Name = P_Name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getP_Name() {
        return P_Name;
    }

    public void setP_Name(String p_Name) {
        P_Name = p_Name;
    }

    public int compareTo(Object o) {
        Product product = (Product) o;
        return this.Price - product.Price;
    }

    public String toString() {
        return "Product [ID=" + ID + ", Price=" + Price + ", P_Name=" + P_Name + "]";
    }

}

class OldProduct extends Product {

    public OldProduct(int Price, String P_Name) {
        super(Price, P_Name);
    }

    public void Discount() {
        setPrice(getPrice() - 15 / 100 * getPrice());
    }

    public String getP_Name() {
        return P_Name;
    }

    public int getPrice() {
        return Price;
    }
}

class NewProduct extends Product {
    NewProduct(int Price, java.lang.String P_Name) {
        super(Price, P_Name);
    }

    public String getP_Name() {
        return P_Name;
    }

    public int getPrice() {
        return Price;
    }

}
