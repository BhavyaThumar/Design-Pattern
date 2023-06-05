import java.util.ArrayList;
import java.util.List;

interface MediatorEntity {

    public void registerBidder(CollegueEntity_Bidder bd);

    public void searchHighestBidAmount();
}

abstract class CollegueEntity_Bidder {
    MediatorEntity md;
    String bName;
    int bPrice;

    public CollegueEntity_Bidder(MediatorEntity m, String name) {
        md = m;
        bName = name;
    }

    public String toString() {
        return bName + ", at the Price of = " + bPrice;
    }

    public int getBidPrice() {
        return bPrice;
    }

    abstract public void bidAmount(int amount);
}

class Bidder1 extends CollegueEntity_Bidder {

    public Bidder1(MediatorEntity m, String name) {
        super(m, name);
    }

    public void bidAmount(int amount) {
        bPrice = amount;
    }

}

class AutionMediator implements MediatorEntity {
    List<CollegueEntity_Bidder> ls = new ArrayList<CollegueEntity_Bidder>();

    public void registerBidder(CollegueEntity_Bidder bd) {
        ls.add(bd);
    }

    public void searchHighestBidAmount() {

        int maxBid = 0;
        CollegueEntity_Bidder b = null;
        for (CollegueEntity_Bidder cb : ls) {
            if (cb.getBidPrice() > maxBid) {
                maxBid = cb.getBidPrice();
                b = cb;
            }
        }
        System.out.println("Winner of the Auction is : " + b);
    }

}

public class Mediator1 {
    public static void main(String[] args) {
        MediatorEntity m1 = new AutionMediator();
        CollegueEntity_Bidder b1 = new Bidder1(m1, "BEADER1");
        CollegueEntity_Bidder b2 = new Bidder1(m1, "BEADER2");
        CollegueEntity_Bidder b3 = new Bidder1(m1, "BEADER3");

        System.out.println("Welcom all Bidder  for all Bidder for auctioning Event:");

        m1.registerBidder(b1);
        m1.registerBidder(b2);
        m1.registerBidder(b3);

        b1.bidAmount(150);
        b2.bidAmount(2500);
        b3.bidAmount(6000);

        System.out.println("Name of the Winner :");
        m1.searchHighestBidAmount();

    }
}