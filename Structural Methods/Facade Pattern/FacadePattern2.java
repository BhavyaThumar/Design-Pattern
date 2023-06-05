// MobileShop interface
// 

interface MobileShop {
    void modelNo();
    void price();
}

class IPhone implements MobileShop {
    public void modelNo() {
        System.out.println("iPhone 14 Noob Min");
    }

    public void price() {
        System.out.println("Rs 100000.00");
    }
}

class Samsung implements MobileShop {
    public void modelNo() {
        System.out.println("Samsung Galaxy S23");
    }

    public void price() {
        System.out.println("Rs 1200000.00");
    }
}

class Realme implements MobileShop {
    public void modelNo() {
        System.out.println("10");
    }

    public void price() {
        System.out.println("Rs 50000.00");      
    }
}

// Facade class
class MobileShopFacade {
    private MobileShop iphone;
    private MobileShop samsung;
    private MobileShop Realme;

    public MobileShopFacade() {
        this.iphone = new IPhone();
        this.samsung = new Samsung();
        this.Realme = new Realme();
    }

    public void iphoneSale() {
        this.iphone.modelNo();
        this.iphone.price();
    }

    public void samsungSale() {
        this.samsung.modelNo();
        this.samsung.price();
    }

    public void RealmeSale() {
        this.Realme.modelNo();
        this.Realme.price();
    }
}

public class FacadePattern2 {
    public static void main(String[] args) {
        MobileShopFacade mobileShopFacade = new MobileShopFacade();

        System.out.println("=== iPhone Sale ===");
        mobileShopFacade.iphoneSale();

        System.out.println("=== Samsung Sale ===");
        mobileShopFacade.samsungSale();

        System.out.println("=== Blackberry Sale ===");
        mobileShopFacade.RealmeSale();
    }
}