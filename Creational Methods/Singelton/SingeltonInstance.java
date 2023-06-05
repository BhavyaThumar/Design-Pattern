class Singelton 

{
    //Static creation of obj is required
    private static Singelton obj = null;
    
    private  Singelton()
    {
        System.out.println("Obj is created");
    }    

    public static Singelton getinstance()
    {
        if (obj == null) 
        {
            obj = new Singelton();
        }
        return obj;
    }
    
}

public class SingeltonInstance
{
    public static void main(String[] args) 
    {
        Singelton obj1= Singelton.getinstance();
        Singelton obj2= Singelton.getinstance();
        System.out.println("OBJ1 = "+obj1);
        System.out.println("OBJ2 = "+obj2);
    }
}