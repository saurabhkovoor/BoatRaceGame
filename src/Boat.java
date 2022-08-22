import java.util.ArrayList;
import java.util.Random;

public class Boat 
{
    //attribute
    String playerName;
    String Boat1Sym = " _B01_ ";
    String Boat2Sym = " _B02_ ";
    String emptyBoatSym = " _____ ";
    String twoPlayers = " B1-B2 ";

    private Dice dice = new Dice();

    private Trap trap = new Trap();
    private Current current = new Current();

    private ArrayList<Integer>  Traps = new ArrayList<Integer>();
    private ArrayList<Integer>  Currents = new ArrayList<Integer>();

    //initialize initial boat location
    private int BoatLocation = 10;

    //constructor
    Boat(){};

    //setter and getter
    public String getPlayerName()
    {
        return playerName;
    }

    public void setPlayerName(String pName)
    {
        playerName = pName;
    }

    public void setBoatLocation(int a)
    {
        BoatLocation += a;
    }

    public int getBoatLocation()
    {
        return BoatLocation;
    }

    //other method
    public void afterCurrent() //d
    {
        current.randGenObjectStrength();
        setBoatLocation(current.getObjectStrength());
        System.out.println("Yay! You've entered a current.");
        System.out.printf("You're pushed forward %d step(s).\n", current.getObjectStrength());
    }

    public void afterTrap()
    {
        trap.randGenObjectStrength();
        setBoatLocation(-trap.getObjectStrength());
        System.out.println("Oops! You hit a trap.");
        System.out.printf("You're set back %d step(s).\n", trap.getObjectStrength());
    }

}
