import java.util.*;

class TreeFlyWeight {

    String type;
    String color;

    public TreeFlyWeight(String t, String c) {
        type = t;
        color = c;
        System.out.println("NEW TFW!!!");
    }
}

class Tree {
    TreeFlyWeight tf;
    int x;
    int y;

    public Tree(TreeFlyWeight t) {
        System.out.println("Tree Object is created!!");

        tf = t;
    }

    public void plantTree(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Tree type - " + tf.type + " planted at X: " + this.x + " Y: " + this.y);
    }
}

class TreeFactory {
    Map<String, TreeFlyWeight> mp = new HashMap<String, TreeFlyWeight>();

    TreeFlyWeight tf = null;

    public TreeFlyWeight createTree(String type) 
    {
        if (mp.containsKey(type)) 
        {
            tf = mp.get(type);
        } 
        else 
        {
            if (type.equalsIgnoreCase("Neem-Tree")) {
                tf = new TreeFlyWeight("Neem-Tree", "Green");
            } else if (type.equalsIgnoreCase("Oak-Tree")) {
                tf = new TreeFlyWeight("Oak-Tree", "Orange");
            } else {
                System.out.println("Tree-type not available!!");
            }
            mp.put(type, tf);
        }
        return tf;
    }
}

class FlyweightDemo {
    public static void main(String[] args) {
        // For loop for N times
        TreeFactory treeFactory = new TreeFactory();
        List<Tree> forest = new ArrayList<Tree>();
        Random random = new Random();
        String[] typesOfTress = new String[] { "Neem-Tree", "Oak-Tree" };
        for (int i = 0; i < 20; i++) {
            TreeFlyWeight tfw = treeFactory.createTree(typesOfTress[random.nextInt(typesOfTress.length)]);
            Tree tree = new Tree(tfw);
            tree.plantTree(random.nextInt(100), random.nextInt(50));
            forest.add(tree);
        }
    }
}
