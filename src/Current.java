import java.util.ArrayList;
import java.util.Random;
public class Current extends GameObject 
{
    //attributes
    private static String currentSymbol = " ~~C~~ ";
    public ArrayList<Integer> Currents = new ArrayList<Integer>();

    //constructor
    //public void current(){ super.GameObject(); };

    //setter and getter
    public static String getCurrentSymbol()
    {
        return currentSymbol;
    }

    public void setCurrentSymbol(String symCurrent)
    {
        this.currentSymbol = symCurrent;
    }

    public ArrayList<Integer> getCurrents(){return Currents;};

    //other methods
    public void addCurrents(ArrayList <Integer> x)
    {
        Random random = new Random();
        //to add 10 currents
        for(int c = 17; c<27; c++)
        {
            int a = random.nextInt(96-c);
            Currents.add(x.get(a));
            x.remove(a);
        }
    }
}
