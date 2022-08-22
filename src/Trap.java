import java.util.ArrayList;
import java.util.Random;
public class Trap extends GameObject 
{
    //attributes
    private static String trapSymbol = " X-T-X ";
    public ArrayList<Integer> Traps = new ArrayList<Integer>();

    //constructor
    //public void trap(){ super.GameObject(); };

    //setter and getter
    public static String getTrapSymbol()
    {
        return trapSymbol;
    }

    public void setTrapSymbol(String symTrap)
    {
        this.trapSymbol = symTrap;
    }

    public ArrayList<Integer> getTraps()
    {
    	return Traps;
    };

    //other methods
    public void addTraps(ArrayList <Integer> x)
    {
        Random random = new Random();
        //to add 10 traps
        for(int c = 17; c<27; c++) //check
        {
            int a = random.nextInt(96-c);
            Traps.add(x.get(a));
            x.remove(a);
        }
    }
}
