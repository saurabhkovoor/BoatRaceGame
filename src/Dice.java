import java.util.Random;
public class Dice 
{
    private int DiceNumber;

    public Dice() 
    {
        this.DiceNumber = 0;
    }

    public int getDiceNumber() 
    {
        return DiceNumber;
    }

    public void setDiceNumber(int diceNumber) 
    {
        DiceNumber = diceNumber;
    }

    public void rollDice() 
    {
        Random roll = new Random();
        int dice = 1 + roll.nextInt( 6 );
        setDiceNumber(dice);
    }

    public void showDiceNumber(String a, int b)
    {
        System.out.printf("\n%s rolled the dice, and got... %d!\n",a,b);
    }
}
