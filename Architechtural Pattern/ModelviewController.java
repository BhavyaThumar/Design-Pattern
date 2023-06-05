class ProductModelEntity {
    int id;
    int price;
    String name;

    public ProductModelEntity(int id, int p, String n) {
        this.id = id;
        price = p;
        name = n;
    }

    public void setPrice(int price) {
        this.price = price - 10;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class ViewEntity {

    public void printProduct(int id, String n, int price) {
        System.out.println("Product Details: id" + id + ", Name: " + n + ", and Price: " + price);
    }
}

class ControllerEntity {

    ProductModelEntity pe;
    ViewEntity ve;

    public ControllerEntity(ProductModelEntity pe, ViewEntity ve) {
        this.pe = pe;
        this.ve = ve;
    }

    public void setPrice(int price) {
        pe.setPrice(price);
    }

    public void setName(String name) {
        pe.setName(name);
    }

    public void updateProductView() {

        ve.printProduct(pe.getID(), pe.getName(), pe.getPrice());
    }
}

public class ModelviewController {

    public static void main(String[] args) {

        ProductModelEntity p1 = new ProductModelEntity(101, 300, "PR1");
        ViewEntity ve = new ViewEntity();

        ve.printProduct(p1.getID(), p1.getName(), p1.getPrice());

        ControllerEntity ce = new ControllerEntity(p1, ve);
        ce.setName("asdf");
        ce.setPrice(564);

        ce.updateProductView();
    }

}