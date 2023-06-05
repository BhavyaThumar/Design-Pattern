class Computer {
    private int HDD;
    private int Ram_Size;
    private String processor_maker;
    private String processor_type;
    private float monitorsize;
    private String OsConfig;
    private String deviceDriver;

    // getter & setters
    public int getHDD() {
        return HDD;
    }

    public void setHDD(int hDD) {
        HDD = hDD;
    }

    public int getRam_Size() {
        return Ram_Size;
    }

    public void setRam_Size(int ram_Size) {
        Ram_Size = ram_Size;
    }

    public String getProcessor_maker() {
        return processor_maker;
    }

    public void setProcessor_maker(String i) {
        this.processor_maker = i;
    }

    public String getProcessor_type() {
        return processor_type;
    }

    public void setProcessor_type(String processor_type) {
        this.processor_type = processor_type;
    }

    public float getMonitorsize() {
        return monitorsize;
    }

    public void setMonitorsize(float monitorsize) {
        this.monitorsize = monitorsize;
    }

    public String getOsConfig() {
        return OsConfig;
    }

    public void setOsConfig(String osConfig) {
        OsConfig = osConfig;
    }

    public String getDeviceDriver() {
        return deviceDriver;
    }

    public void setDeviceDriver(String deviceDriver) {
        this.deviceDriver = deviceDriver;
    }

    public String toString() {
        return "Computer [ HDD=" + HDD + ", Ram_Size=" + Ram_Size + ", processor_maker = " + processor_maker
                + ", processor_type = " + processor_type + ", monitorsize = " + monitorsize + ", OsConfig = " + OsConfig
                + ", deviceDriver = " + deviceDriver + "]";
    }

}

abstract class ComputerBuilder {
    protected Computer computer;

    public ComputerBuilder() {
        computer = new Computer();
    }

    public Computer getcomputer() {
        return computer;
    }

    abstract void configHdd();

    abstract void configRam_Size();

    abstract void configprocessor_maker();

    abstract void configprocessor_type();

    abstract void configmonitorsize();

    abstract void configOsConfig();

    abstract void configdeviceDriver();
}

// Concrete Builder1
class ServerComputerBuilder extends ComputerBuilder {
    // configuring computer
    public void configHdd() {
        computer.setHDD(1024);
    }

    public void configRam_Size() {
        computer.setRam_Size(64);
    }

    public void configprocessor_maker() {
        computer.setProcessor_maker("AMD RyZEN");
    }

    public void configprocessor_type() {
        computer.setProcessor_type("Ryzen 12");
}

    public void configmonitorsize() {
        computer.setMonitorsize(2);
    }

    public void configOsConfig() {
        computer.setOsConfig("Unix");
    }

    public void configdeviceDriver() {
        computer.setDeviceDriver("USB - Exterrnal HDD");
    }
}

// Concrete Builder2
class PersonalComputerBuilder extends ComputerBuilder {
    // configuring computer
    public void configHdd() {
        computer.setHDD(100);
    }

    public void configRam_Size() {
        computer.setRam_Size(16);
    }

    public void configprocessor_maker() {
        computer.setProcessor_maker("INTEL");
    }

    public void configprocessor_type() {
        computer.setProcessor_type("I5");
    }

    public void configmonitorsize() {
        computer.setMonitorsize(15);
    }

    public void configOsConfig() {
        computer.setOsConfig("FEDORA");
    }

    public void configdeviceDriver() {
        computer.setDeviceDriver("Wifi-Mouse");
    }
}

class HardwarEngineer {
    private ComputerBuilder computerBuilder;

    public void setComputerbuilder(ComputerBuilder compbuilder) {
        computerBuilder = compbuilder;
    }

    public Computer getComputer() {
        return computerBuilder.getcomputer();
    }

    public void buildcomputer() {
        computerBuilder.configHdd();
        computerBuilder.configOsConfig();
        computerBuilder.configRam_Size();
        computerBuilder.configdeviceDriver();
        computerBuilder.configmonitorsize();
        computerBuilder.configprocessor_maker();
        computerBuilder.configprocessor_type();
    }
}

public class BuilderMethod {
    public static void main(String[] args) {

        // Instantiating obj of a PersonalComputerBuilder & ServerComputerBuilder for
        // passing in setComputerbuilder to create that type of computer

        ServerComputerBuilder sc1 = new ServerComputerBuilder();
        PersonalComputerBuilder pc1 = new PersonalComputerBuilder();
        HardwarEngineer he = new HardwarEngineer();
        he.setComputerbuilder(pc1);
        he.buildcomputer();

        Computer stored = he.getComputer();

        System.out.println(stored);

        he.setComputerbuilder(sc1);
        he.buildcomputer();
        stored = he.getComputer();
        System.out.println("\n");
        System.out.println(stored);
    }
}   