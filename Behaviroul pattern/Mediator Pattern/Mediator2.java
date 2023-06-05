import java.util.*;

interface MediatorEntity {

    public void registerBidder(CollegueEntity_Bidder bd);

    public void searchHighestBidAmount();
}

abstract class Plane_Register
{
    MediatorEntity md;
    String Plane_ID;
    int priority;

    Plane_Register(MediatorEntity m, String id)
    {
        md = m;
        Plane_ID = id;
    }

    public String toString() {
        return Plane_ID + "Is Landing ";
    }

    public int getBidPrice() {
        return priority;
    }

    abstract public void Prioritys(int p);
}

class Plane extends Plane_Register {

    public Plane(MediatorEntity m, String id) {
        super(m, id);
    }

    public void Prioritys(int p) {
        priority = p;
    }

}

