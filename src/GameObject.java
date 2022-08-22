import java.util.ArrayList;
import java.util.Random;

public class GameObject 
{
    //Attributes
    private int objectStrength;
    ArrayList<Integer> objectsList = new ArrayList<Integer>();

    //constructor
    public void GameObject()
    {
        this.objectStrength = 0;
    }

    //setter and getter
    public int getObjectStrength() 
    {
        return objectStrength;
    }

    public void setObjectStrength(int strength) 
    {
        this.objectStrength = strength;
    }

    public void setObjectsList()
    {
        for(int c= 11; c < 100; c++)
        {
            objectsList.add(c);
        }
    }

    public ArrayList<Integer> getObjectsList()
    {
        return objectsList;
    }

    //other methods
    public void randGenObjectStrength()
    {
        setObjectStrength(randNumGenerate(1,6));
    }

    public int randNumGenerate(int startPosition, int endPosition)
    {
        Random random = new Random();
        return (random.nextInt(endPosition - startPosition + 1) + startPosition);
    }
}
