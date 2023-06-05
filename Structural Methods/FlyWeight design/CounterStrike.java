import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class playerFlyWeight
{
    String type;
    String colorCode;
    String task;
    
    public playerFlyWeight(String t, String colorcode, String tasks) {
        type = t;
        colorCode = colorcode;
        task=tasks;
        System.out.println("New Type of Player !!!!");
    }
}

class player
{
    playerFlyWeight p;
    static String[] weaponList= new String[] {"AWP","M4A1-s","Five-Seven","SG 553","Deagle"};
    String weapon;
    int x,y;
    public player(playerFlyWeight p1)
    {
        System.out.println("Player  Generated");
        p=p1;
    }

    public void Spawn(String weapon , int x, int y) {
        this.x=x;
        this.y=y;
        this.weapon=weapon;
        System.out.println("Player Type - " + p.type +"Uses"+ weapon + " , Spwaned at" + this.x + " , " + this.y);
    }
}

class PlayerFactory {
    Map<String ,playerFlyWeight> Players = new HashMap<String ,playerFlyWeight>();

    playerFlyWeight pw = null;
    public playerFlyWeight createPlayer(String type) 
    {
        if(Players.containsKey(type))
        {
            pw = Players.get(type);
        }
        else
        {
            if(type.equalsIgnoreCase("Counter-Terrorist"))
            {
                pw = new playerFlyWeight("Counter-Terrorist","BLUE","Defend the ground");
            }
            else if(type.equalsIgnoreCase("Terrorist"))
            {
                pw = new playerFlyWeight("Terrorist","GREEN","KILLLL");
            }
            else
            {
                System.out.println("Type DNE !!!");
            }
            Players.put(type, pw);
        }
        return pw;
    }
}

class CounterStrike{
    public static void main(String[] args) {
        PlayerFactory playerFactory = new PlayerFactory();
        List<player> playground = new ArrayList<player>();
        Random random = new Random();
        String[] TypesofPlayers = new String[] {"Terrorist", "Counter-Terrorist"};
        
        for(int i =0 ; i < 10 ; i++)
        {
            playerFlyWeight pfw = playerFactory.createPlayer(TypesofPlayers[random.nextInt(TypesofPlayers.length)]);
            player pla = new player(pfw);
            pla.Spawn(player.weaponList[random.nextInt(player.weaponList.length)], random.nextInt(), random.nextInt());
            playground.add(pla);
        }

        System.out.println("Consumption of Memory = ");
    }
}
