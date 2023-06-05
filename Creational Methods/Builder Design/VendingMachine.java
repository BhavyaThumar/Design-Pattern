class Beverage 
{
    private int Calorie;
    private int Price;
    private String Name;
    private String Type;
    public int getCalorie() {
        return Calorie;
    }
    public void setCalorie(int calorie) {
        Calorie = calorie;
    }
    public int getPrice() {
        return Price;
    }
    public void setPrice(int price) {
        Price = price;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getType() {
        return Type;
    }
    public void setType(String type) {
        Type = type;
    }

    public String toString() {
        return "Beverage [Calorie=" + Calorie + ", Price=" + Price + ", Name=" + Name + ", Type=" + Type + "]";
    }
}

abstract class BeverageBuilder 
{
    protected Beverage beverage;
    public void BeverageBuilder()
    {
        beverage =new Beverage();
    }

    public Beverage getBeverage()
    {
        return beverage;
    }

    abstract void setCalorie();
    abstract void selPrice();
    abstract void selPrice();
    abstract void selPrice();
    
}