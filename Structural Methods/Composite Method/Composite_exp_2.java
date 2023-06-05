import java.util.ArrayList;
import java.util.List;

abstract class Component 
{
    protected String name;

    public Component(String n) {
        name = n;
    }

    public abstract void describeComponent();

    public abstract int getsize();
}

class File extends Component {
    
    protected int file_size;
    protected String file_type;

    public File(String n , int fs, String ft)
    {
        super(n);
        file_size = fs;
        file_type = ft;
    }
    public void describeComponent() {
        System.out.println(name+"\t");
        System.out.print("File Size  "+file_size+"\t");
        System.out.println("File Type  "+file_type);
    }
    public int getsize() 
    {
        return file_size;
    }
    
}

class Folder extends Component 
{
    
    public Folder(String n) 
    {
        super(n);
    }

    List<Component> list1 = new ArrayList<Component>();

    public void describeComponent() 
    {
        
        System.out.println(name);
        
        for(Component c : list1)
        {
            c.describeComponent();
        }
    }

    public int getsize() 
    {    
        int tot = 0;
        for(Component c : list1)
        {
            tot+=c.getsize();
        }
        return tot;
    }

    public void addComponent(Component c) {
        list1.add(c);
    }

    public void removeComponent(Component c) {
        list1.remove(c);
    }

    public List Componentlist() {
        return list1;
    }

}

public class Composite_exp_2 
{
    public static void main(String[] args) 
    {
        Component l1 = new File("ABC.java", 100, "Java");
        Component l2 = new File("DEF.java", 1024, "Java" );
        Component l3 = new File("GHI.TXT", 540, "TXT" );
        Component l4 = new File("JKL.TXT", 2048, "TXT" );
        Component l5 = new File("MNO.excel", 770, "Excel");

        Folder c1 = new Folder("Java");
        Folder c2 = new Folder("TXT");
        Folder c3 = new Folder("Excel");

        c1.addComponent(l1);
        c1.addComponent(l2);

        c2.addComponent(l3);
        c2.addComponent(l4);

        c3.addComponent(l5);

        l2.describeComponent();
        c2.describeComponent();

        
        System.out.println(c2.name + " : " + c2.getsize());
    }
}