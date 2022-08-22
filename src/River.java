import java.util.ArrayList;
public class River 
{
    private String twoPlayers = " B1-B2 ";

    private int Case=0;

    String[] riverTrack = new String[]
    		{"  -1-  ", "  -2-  ", "  -3-  ", "  -4-  ", "  -5-  ", "  -6-  ", "  -7-  ", "  -8-  ", "  -9-  ","  -10-  ",
            " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ "," _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ "," _____ ",
            " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ "," _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ "," _____ ",
            " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ "," _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ "," _____ ",
            " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ "," _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ "," _____ ",
            " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ "," _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ ", " _____ "," _____ "};

    //constructor
    public void River(){}

    //setter and getter
    public void setTwoPlayers(String TwoPlayers)
    {
        this.twoPlayers = TwoPlayers;
    }

    public String getTwoPlayers()
    {
        return twoPlayers;
    };

    //other methods
    public void displayRiver()
    {
        //to make the riverTrack wrap on to the next line after every 10th cell in a row
        for (int c = 0; c < riverTrack.length; c++)
        {
            System.out.print(riverTrack[c]);
            if(c == 9 || c == 19 || c == 29 || c == 39 || c == 49 || c == 59 || c == 59 || c == 69 || c == 79 || c == 89 || c == 99)
                System.out.println();
        }
        System.out.print("\n\n");
    }

    public void updateRiverCell(int a, String b)
    {
        riverTrack[a] = b;
    }

    //to add traps and currents to River Track
    public void setRiverTrack(ArrayList <Integer> t, ArrayList <Integer> c)
    {
        for (int a:c)
        {
            riverTrack[a] = Current.getCurrentSymbol();
        }

        for (int b:t)
        {
            riverTrack[b] = Trap.getTrapSymbol();
        }
    }

    public void setCase(int a, int b)
    {
        if(a==b)
        {
        	Case=1;
        }
        else if(a!=b)
        {
        	Case=2;
        }
        //to ensure that boat doesn't move before position 1 or collide with column identifiers
        else if(a!=b && a<10)
        {
        	Case=3;
        }
    }

    public int getCase()
    {
        return Case;
    }
}


