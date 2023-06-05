import java.util.ArrayList;
import java.util.List;

class SubjectEntity {

    private int numberstate;

    private List<ObserverEntity> lm = new ArrayList<ObserverEntity>();

    public int getNumberstate() {
        return numberstate;
    }

    public void setNumberstate(int numberstate) {
        this.numberstate = numberstate;
        notifyAllObservers();
    }

    public void registerObserver(ObserverEntity e) {
        lm.add(e);
    }

    public void UnregisterObserver(ObserverEntity e) {
        lm.remove(e);
    }

    public void notifyAllObservers() {
        for (ObserverEntity e : lm) {
            e.update();
        }
    }
}

abstract class ObserverEntity {
    SubjectEntity se;

    abstract public void update();
}

class BinaryObserverEntity extends ObserverEntity {

    public BinaryObserverEntity(SubjectEntity e) {
        se = e;
    }

    public void update() {

        int n = se.getNumberstate();
        System.out.println("Representing number " + n + " to binary: " + Integer.toBinaryString(n));

    }
}

class HexaObserverEntity extends ObserverEntity {

    public HexaObserverEntity(SubjectEntity e) {
        se = e;
    }

    public void update() {
        int n = se.getNumberstate();
        System.out.println("Representing number " + n + " to Hexa : " + Integer.toHexString(n));
    }
}

class OctalObserverEntity extends ObserverEntity {

    public OctalObserverEntity(SubjectEntity e) {
        se = e;
    }

    public void update() {
        int n = se.getNumberstate();
        System.out.println("Representing number " + n + " to Octal: " + Integer.toOctalString(n));
    }
}

public class Observer1 {
    public static void main(String[] args) {

        SubjectEntity se = new SubjectEntity();
        ObserverEntity o1 = new BinaryObserverEntity(se);
        se.registerObserver(o1);
        se.setNumberstate(12);

        ObserverEntity o2 = new OctalObserverEntity(se);
        se.registerObserver(o2);
        se.setNumberstate(22);
    }
}