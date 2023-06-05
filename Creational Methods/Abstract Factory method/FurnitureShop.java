//Abstract Factory Method
import java.util.Scanner;

//Abstract prod. 1
interface Chair {
    float Chairprice();
    String ChairType();
}

// Abstract prod. 2
interface Table {
    float Tableprice();
    String TableType();
}

// Abstract prod. 3
interface Sofa {
    float Sofaprice();
    String SofaType();
}

class OfficeChair implements Chair {
    public float Chairprice() {
        return 899.99f;
    }

    public String ChairType() {
        return "Office BMobileFactorys Chair\tOffice Employee Chair";
    }
}

class HomeChair implements Chair {
    public float Chairprice() {
        return 999f;
    }
    public String ChairType() {
        return "Guest Chair";
    }
}

class OfficeTable implements Table {
    public float Tableprice() {
        return 1599f;
    }

    public String TableType() {
        return "Plastic Table\tWood Table";
    }
}

class HomeTable implements Table {

    public float Tableprice() {
        return 1999f;
    }

    public String TableType() {
        return "Dining Table";
    }
}

class OfficeSofa implements Sofa {

    public float Sofaprice() {
        return 19999f;
    }

    public String SofaType() {
        return "Office Sofa";
    }
}

class HomeSofa implements Sofa {

    public float Sofaprice() {
        return 24999f;
    }

    public String SofaType() {
        return "Home Sofa";
    }
}

// Abstract Furniture Factory
interface AbstractFactory {
    Chair createChair();

    Sofa createSofa();

    Table createTable();
}

// Concrete Factory1
class Office implements AbstractFactory {

    public Chair createChair() {
        return new OfficeChair();
    }

    public Sofa createSofa() {
        return new OfficeSofa();
    }

    public Table createTable() {
        return new OfficeTable();
    }
}

// Concrete Factory2
class Home implements AbstractFactory {

    public Chair createChair() {
        return new HomeChair();
    }

    public Sofa createSofa() {
        return new HomeSofa();
    }

    public Table createTable() {
        return new HomeTable();
    }
}

class FurnitureFactory {
    public AbstractFactory getFurniture(String f) {
        Scanner sf = new Scanner(System.in);
        switch (f.toLowerCase()) {
            case "office":
                System.out.println("Enter your furniture type : [Table, Sofa, Chair]");
                String of = sf.nextLine();
                switch (of.toLowerCase()) {
                    case "table":
                        OfficeTable ot = new OfficeTable();
                        System.out.println("Type of table is: " + ot.TableType());
                        System.out.println("Price of table is: " + ot.Tableprice());
                        break;
                    case "chair":
                        OfficeChair oc = new OfficeChair();
                        System.out.println("Type of chair is: " + oc.ChairType());
                        System.out.println("Price of chair is: " + oc.Chairprice());
                        break;
                    case "sofa":
                        OfficeSofa os = new OfficeSofa();
                        System.out.println("Type of sofa is: " + os.SofaType());
                        System.out.println("Price of sofa is: " + os.Sofaprice());
                        break;
                    default:
                        System.out.println("Enter valid furniture type!!");
                        break;
                }
                break;
            case "home":
                System.out.println("Enter your furniture type : [Table, Sofa, Chair]");
                String hf = sf.nextLine();
                switch (hf.toLowerCase()) {
                    case "table":
                        HomeTable ht = new HomeTable();
                        System.out.println("Type of table is: " + ht.TableType());
                        System.out.println("Price of table is: " + ht.Tableprice());
                        break;
                    case "chair":
                        HomeChair hc = new HomeChair();
                        System.out.println("Type of chair is: " + hc.ChairType());
                        System.out.println("Price of chair is: " + hc.Chairprice());
                        break;
                    case "sofa":
                        HomeSofa hs = new HomeSofa();
                        System.out.println("Type of sofa is: " + hs.SofaType());
                        System.out.println("Price of sofa is: " + hs.Sofaprice());
                        break;
                    default:
                        System.out.println("Enter valid furniture type!!");
                        break;
                }
                break;
            default:
                System.out.println("Enter valid choice [Office, Home]");
                break;
        }
        return null;

    }
}

public class FurnitureShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice for furniture : [Office, Home]");
        String ch = sc.nextLine();
        FurnitureFactory ff = new FurnitureFactory();
        AbstractFactory af = ff.getFurniture(ch);
    }
}
