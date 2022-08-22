import java.util.*;

public class UserInput
{
    private int number = -1;
    public UserInput()
    {
        setNumber();
        getNumber();
        checkNumber(getNumber());
    }

    public void setNumber()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("\nChoose an action by entering a number between 1 and 4: ");
        try
        {
            number = input.nextInt();
            while (number < 1 || number > 4)
            {
                System.out.println("That number is not in range. Please enter a valid number between 1 and 4. ");
                number = input.nextInt();
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("That is not a valid input. Please enter a valid number between 1 and 4. ");
            setNumber();
        }
    }

    public int getNumber()
    {
        return number;
    }

    //other method
    public void checkNumber(int x){
        switch(x){
            case 1:
                new boat_race_game_driver();
                UserInput t = new UserInput();
                break;
            case 2:
                instructions();
                UserInput u = new UserInput();
                break;
            case 3:
                Leaderboard l = new Leaderboard();
                UserInput v = new UserInput();
                break;
            case 4:
                System.out.println("Thank you come again!");
                System.exit(0);
            break;
        }
    }

    public void instructions(){
        System.out.println("\nINSTRUCTIONS");
        System.out.println("1. Firstly, the game prepares the river track.\n   To better visualise it, the track will consist of 10 rows with 10 columns.");
        System.out.println("2. Then, the game will randomly place traps and currents on the river track.");
        System.out.println("3. Players will then get chance to roll the dice, which determines how many steps they should take.");
        System.out.println("4. TO WIN, reach the end of the river before your opponent.");
        System.out.println("5. Players start with 100 points each and after every turn their points are deducted by 2.");
        System.out.println("6. When players step on a current their points are increased by 5.");
        System.out.println("7. However, when players step on a trap their points are deducted by 5.");
        System.out.println("8. The player with the most points Wins!\n");
    }

    public String toString()
    {
        return String.format("Your menu option: %s",
                number);
    }
}