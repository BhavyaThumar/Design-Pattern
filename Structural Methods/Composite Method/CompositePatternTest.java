import java.util.ArrayList;
import java.util.List;

abstract class Component {
    protected String name;

    public Component(String n) {
        name = n;
    }

    public abstract void describeComponent();

    public abstract int getprice();
}

class Leaf extends Component {
    protected int price;

    public Leaf(String n, int p) {
        super(n);
        price = p;
    }

    public void describeComponent() {
        System.out.println(name);
        System.out.print("\t" + price + "\n");
    }

    public int getprice() {
        return price;
    }

}

class Composite extends Component {
    List<Component> ls = new ArrayList<Component>();

    public Composite(String n) {
        super(n);
    }

    public int getprice() {
        int p = 0;
        for (Component c : ls) {
            p += c.getprice();
        }
        return p;
    }

    public void addComponent(Component c) {
        ls.add(c);
    }

    public void removeComponent(Component c) {
        ls.remove(c);
    }

    public List Componentlist() {
        return ls;
    }

    public void describeComponent() {
        System.out.println(name);

        // Ls Containing Component So Component
        for (Component c : ls) {
            c.describeComponent();
        }
    }
}

public class CompositePatternTest {
    public static void main(String[] args) {
        Component l1 = new Leaf("Hdd", 100);
        Component l2 = new Leaf("RAM", 200);
        Component l3 = new Leaf("CPU", 500);
        Component l4 = new Leaf("Mouse", 400);
        Component l5 = new Leaf("KeyBoard", 900);

        Composite c1 = new Composite("Computer");
        Composite c2 = new Composite("Cabinet");
        Composite c3 = new Composite("Peripheral");
        Composite c4 = new Composite("MotherBoard");

        c1.addComponent(c2);
        c1.addComponent(c3);

        c2.addComponent(l1);
        c2.addComponent(c4);

        c3.addComponent(l4);
        c3.addComponent(l5);

        c4.addComponent(l2);
        c4.addComponent(l3);

        l1.describeComponent();
        c4.describeComponent();

        System.out.println(c2.name + " : " + c2.getprice());
    }
}