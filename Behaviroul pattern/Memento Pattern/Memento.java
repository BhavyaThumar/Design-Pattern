import java.util.ArrayList;
import java.util.List;

class OriginartorObj
{
    private int temperature;
    private int volume;

    public OriginartorObj(int t , int v)
    {
        volume = v;
        temperature = t;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    //Originator creating snapshot
    public MementoObject saveObjectstate()
    {
        //obj of memento
        return new MementoObject(temperature, volume); 
    }

    //trying to restore state of obj
    public void restoreObjectState(MementoObject m)
    {
        temperature = m.getTemperature();
        volume = m.getVolume();
    }

    public void operateMachine() {
        System.out.println("OriginartorObj [temperature=" + temperature + ", volume=" + volume + "]");
    }
}

//Memento never Come up with Setter methods 
class MementoObject
{
    private int temperature;
    private int volume;

    public MementoObject(int t , int v)
    {
        volume = v;
        temperature = t;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getVolume() {
        return volume;
    }
}

class CareTakerObject
{
    List<MementoObject> lm = new ArrayList<MementoObject>();
    public void addMementoObject(MementoObject m ) {
        lm.add(m);
    }  
    
    public MementoObject getMementoObject(int i) {
        return lm.get(i);
    }
}

public class Memento
{
    public static void main(String[] args) {

        OriginartorObj o1 = new OriginartorObj(200, 103);
        CareTakerObject c = new CareTakerObject();
        
        o1.operateMachine();
        c.addMementoObject(o1.saveObjectstate());

        o1.setTemperature(210);
        o1.setVolume(280);
        o1.operateMachine();
        c.addMementoObject(o1.saveObjectstate());
        
        o1.setTemperature(800);
        o1.setVolume(890);

        o1.operateMachine();
        c.addMementoObject(o1.saveObjectstate());
        
    }
}