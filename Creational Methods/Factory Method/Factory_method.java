import java.util.Scanner;

interface Vehical {
    float getfixedcharge();
    float getKMcharge();
}

class Car implements Vehical {
    public float getfixedcharge() {
        return 25;
    }

    public float getKMcharge() {
        return 18;
    }
}

class Auto implements Vehical {
    public float getfixedcharge() {
        return 20;
    }

    public float getKMcharge() {
        return 12;
    }
}

//Factory Class
class VehicalFectory {
    public Vehical getVehical(String s) {
        switch (s) {
            case "Car":
                return new Car();
            case "Auto":
                return new Auto();
            default:
                System.out.println("Enter valid Vehical..!");
                return null;
        }
    }
}

public class Factory_method {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a type of vehical which you want.");
        String s = sc.nextLine();
        VehicalFectory vf = new VehicalFectory();
        Vehical v = vf.getVehical(s);
        System.out.println("Per KM charge " + v.getKMcharge());
        System.out.println("Fixed charge " + v.getfixedcharge());
    }
}                         