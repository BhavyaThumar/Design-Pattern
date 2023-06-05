//Abstract Factory Method

import java.util.*

interface Vehicle
{
    public void getFixedcharge();
    public void getPerKMcharge();
}

public class AutoRikshaw implements Vehicle
{
    public void getFixedcharge() 
    {
        int fixedcharge = 100; 
    }

    public void getPerKMcharge() 
    {
        int pkc= 10;
    }
}

public class Car implements Vehicle
{
    public void getFixedcharge() 
    {
        int fixedcharge = 150; 
    }

    public void getPerKMcharge() 
    {
        int pkc= 15;
    }
}

public class VehicleFactory
{
    public Vehicle createVehicle(String type)
    {
        switch (type) 
        {
            case "CAR":
                return new Car();

            case "AutoRikshaw":
                return new AutoRikshaw(); 

            default:
                System.out.println("Find other Vehicle");
                return null;            
        }
    }
}

public class Sasta_UBER
{
    public static void main(String[] args) 
    {
        String type;
        Scanner sc = new Scanner(System.in);
    }
}
