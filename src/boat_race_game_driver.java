import java.util.Scanner;
	
public class boat_race_game_driver 
{
        Scanner scanner = new Scanner(System.in);

        GameObject obj = new GameObject();
        River r = new River();

        Boat player1 = new Boat();
        Boat player2 = new Boat();

        //player 1's dice
        Dice dplayer1 = new Dice();

        //player 2's dice
        Dice dplayer2 = new Dice();

        Trap trap = new Trap();
        Current current = new Current();

        //attributes
        int score1=100;
        int score2=100;

        int turns = 0;

        final int CurrentScore = 5;
        final int TrapScore = -5;
        final int TurnsScore = -2;

        //constructor
        boat_race_game_driver()
        {
            playGame();
        }

        //User input- name
        public void playGame()
        {
            do
            {
            	System.out.print("Hello Player 1! Enter your Name (Must be no more than 10 characters long): ");
                player1.playerName= scanner.nextLine();
                if(player1.playerName.length() > 10 || player1.playerName.length() <= 0)
                {
                	System.out.println("Error! Your name should be no more than 10 characters long\n");
                    continue;
                }
                else
                {
                	break;
                }
            }
            while(true);


            do
            {
            	System.out.print("Hello Player 2! Enter your Name (Must be no more than 10 characters long): ");
                player2.playerName= scanner.nextLine();
                if(player2.playerName.length() > 10 || player2.playerName.length() <= 0)
                {
                	System.out.println("Error! Your name should be no more than 10 characters long\n");
                    continue;
                }
                else
                {
                	break;
                }
                
            }
            while(true);


        //Loading messages
            System.out.println();
            System.out.println("Loading Game...");
            System.out.println("Setting Traps and Currents...");
            System.out.println("Creating Boats...");
            System.out.println();

        //Creating game
            obj.setObjectsList();
            trap.addTraps(obj.objectsList);
            current.addCurrents(obj.objectsList);

        //starting position
            r.setCase(player1.getBoatLocation(), player2.getBoatLocation());
            switch (r.getCase())
            {
                case 1:
                    r.updateRiverCell(player1.getBoatLocation(), r.getTwoPlayers());
                    break;

                case 2:
                    r.updateRiverCell(player1.getBoatLocation(), player1.Boat1Sym);
            }


            r.setRiverTrack(trap.Traps, current.Currents);
            r.displayRiver();

            //to ensure that boats cannot move past position 100(array position 109). Captures the error when boat moves past array
            try
            {
	            while (player1.getBoatLocation()<109 && player2.getBoatLocation()<109)
	            {
	                //player 1 turn
	                System.out.printf("%s (B1), type or enter anything to roll the dice: ",player1.playerName);
	                scanner.nextLine();
	                turns++;
	
	                dplayer1.rollDice();//try to include below?
	                player1.setBoatLocation(dplayer1.getDiceNumber());
	                dplayer1.showDiceNumber("B1", dplayer1.getDiceNumber());
	
	
	                //after player 1 has moved forward need to change the first position (or where position B1 = position B2) from B1_B2 to B2
	                r.setCase((player1.getBoatLocation() - dplayer1.getDiceNumber()), player2.getBoatLocation());
	                switch(r.getCase())
	                {
	                    case 1:
	                        r.updateRiverCell((player1.getBoatLocation() - dplayer1.getDiceNumber()), player2.Boat2Sym);
	                        break;
	                    case 2:
	                        r.updateRiverCell((player1.getBoatLocation() - dplayer1.getDiceNumber()), player1.emptyBoatSym);
	                        break;
	                }
	
	                //If boat1 hits a current or trap
	                while(trap.Traps.contains(player1.getBoatLocation()) || current.Currents.contains(player1.getBoatLocation()))
	                {
	                    if(trap.Traps.contains(player1.getBoatLocation()))
	                    {
	                        player1.afterTrap();
	                        score1 += TrapScore;
	                    }
	                    else if (current.Currents.contains(player1.getBoatLocation()))
	                    {
	                        player1.afterCurrent();
	                        score1 += CurrentScore;
	                    }
	                    else
	                    {
	                    	break;
	                    }
	                }
	
	                //final part of turn (Boat 1), updating boats position in the river track based on the BoatLocation
	                r.setCase(player1.getBoatLocation(), player2.getBoatLocation());
	                switch(r.getCase())
	                {
	                    case 1:
	                        r.updateRiverCell(player1.getBoatLocation(), r.getTwoPlayers());
	                        break;
	                    case 2:
	                        r.updateRiverCell(player1.getBoatLocation(), player1.Boat1Sym);
	                        break;
	
	                    //if boat goes before position 1 colliding with the column identifiers
	                    case 3:
	                        player1.setBoatLocation(10);
	                        r.updateRiverCell(player1.getBoatLocation(), player1.Boat1Sym);
	                }
	
	                r.displayRiver();
	
	                //player 2 turn
	                System.out.printf("%s (B2), type or enter anything to roll the dice: ",player2.playerName);
	                scanner.nextLine();
	                dplayer2.rollDice();//try to include below?
	                player2.setBoatLocation(dplayer2.getDiceNumber());
	                dplayer2.showDiceNumber("B2", dplayer2.getDiceNumber());
	
	                //after player 2 has moved forward need to change the first position(or where position B1 = position B2) from B1_B2 to B1
	                r.setCase((player2.getBoatLocation() - dplayer2.getDiceNumber()), player1.getBoatLocation());
	                switch(r.getCase())
	                {
	                    case 1:
	                        r.updateRiverCell(player1.getBoatLocation(), player1.Boat1Sym);
	                        break;
	                    case 2:
	                        r.updateRiverCell(player2.getBoatLocation() - dplayer2.getDiceNumber(), player2.emptyBoatSym);
	                        break;
	                }
	
	                //If boat2 hits a current or trap
	                while(trap.Traps.contains(player2.getBoatLocation()) || current.Currents.contains(player2.getBoatLocation())){
	                    if(trap.Traps.contains(player2.getBoatLocation()))
	                    {
	                        player2.afterTrap();
	                        score2 += TrapScore;
	                    }
	                    else if (current.Currents.contains(player2.getBoatLocation()))
	                    {
	                        player2.afterCurrent();
	                        score2 += CurrentScore;
	                    }
	                    else
	                    {
	                    	break;
	                    }
	                }
	
	                //final part of turn (Boat 2), updating boats position in the river track based on the BoatLocation
	                r.setCase(player2.getBoatLocation(), player1.getBoatLocation());
	                switch(r.getCase()){
	                    case 1:
	                        r.updateRiverCell(player2.getBoatLocation(), r.getTwoPlayers());
	                        break;
	                    case 2:
	                        r.updateRiverCell(player2.getBoatLocation(), player2.Boat2Sym);
	                        break;
	
	                    //if boat goes before position 1 colliding with the column identifiers
	                    case 3://check
	                        player2.setBoatLocation(10);
	                        r.updateRiverCell(player2.getBoatLocation(), player2.Boat1Sym);
	                }
	                r.displayRiver();
	
	            }
            }
            catch (Exception e){System.out.println("GAME OVER");}//when boat moves past the board, this should capture the indexoutofbounds error, indicating game has finished

            finally
            {//calculating score based on number of turns and checking winner
	            score1 += (turns * TurnsScore);
	            score2 += (turns * TurnsScore);
	
	            if(score1 > score2 || player1.getBoatLocation()>=109)
	            {//before: player1.getBoatLocation()>109
	                System.out.printf("Congrats %s (Boat1)!!! You've won!\n", player1.playerName);
	                System.out.printf("Boat 1 Score: %d\n", score1);
	                System.out.printf("Boat 2 Score: %d\n", score2);
	
	                System.out.printf("Number of Turns: %d", turns);
	            }
	
	            else if(score2 > score1 || player2.getBoatLocation()>=109)
	            {//before: player2.getBoatLocation()>109
	                System.out.printf("Congrats %s (Boat2)!!! You've won!\n", player2.playerName);
	                System.out.printf("Boat 1 Score: %d\n", score1);
	                System.out.printf("Boat 2 Score: %d\n", score2);
	                System.out.printf("Number of Turns: %d", turns);
	            }
	            else
	            {
	                System.out.printf("Oh No! It's a tie\n");
	                System.out.printf("Boat 1 Score: %d\n", score1);
	                System.out.printf("Boat 2 Score: %d\n", score2);
	
	                System.out.printf("Number of Turns: %d", turns);
	            }
            }
        }
}
