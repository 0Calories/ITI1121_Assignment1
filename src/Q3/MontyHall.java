package Q3;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


/**
 * The class <b>MontyHall</b> simulates one game. Is uses three <b>Door</b> objects
 * to simulate the three doors. One game consists of the following steps
 * <ol>
 * <li>Resets all three doors</li>
 * <li>Simulates the selection of one of the doors by the player</li>
 * <li>Simulates opening of an empty door by the host</li>
 * <li> provide the outcome for switching and not switching door</li>
 * </ol>
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */
public class MontyHall
{

    private Door d1;
    private Door d2;
    private Door d3;

    Statistics stats;

    /**
     * Initializes the three doors.
     */
    public MontyHall()
    {
        d1 = new Door("Door A");
        d2 = new Door("Door B");
        d3 = new Door("Door C");
        stats = new Statistics();
    }

    /**
     * Simulates one Monty Hall game.
     * <ol>
     * <li>Resets all three doors</li>
     * <li>Simulates the selection of one of the doors by the player</li>
     * <li>Simulates opening of an empty door by the host</li>
     * <li>prints the outcome for switching and not switching door to standard output</li>
     * </ol>
     */
    public void oneGame()
    {
        d1.reset();
        d2.reset();
        d3.reset();

        //Generate a random number from 1 to 3 that will determine which door contains the prize

        Random rand = new Random();
        int prizeDoor = rand.nextInt(3) + 1;
        Door prizeD = d1;

        if (prizeDoor == 1)
        {
            d1.setPrize();
            prizeD = d1;
        }
        else if (prizeDoor == 2)
        {
            d2.setPrize();
            prizeD = d2;
        }
        else if (prizeDoor == 3)
        {
            d3.setPrize();
            prizeD = d3;
        }

        //Simulate the player picking a door
        Door chosenDoor = pickADoor();

        //Simulate the host opening a door
        Door openDoor = openOtherDoor(prizeD, chosenDoor);
        openDoor.open();

        //Update the statistics at the end of the game
        stats.updateStatistics(d1, d2, d3);
    }

    /**
     * Simulates a random selection of one of the three doors.
     * @return the door randomly selected
     */
    private Door pickADoor()
    {
        //Generate a random number between 1 to 3, the number generated determines the choice of the player
        Random rand = new Random();
        int playerChoice = rand.nextInt(3) + 1;

        if (playerChoice == 1)
        {
            d1.choose();
            return d1;
        }
        else if (playerChoice == 2)
        {
            d2.choose();
            return d2;
        }
        else if (playerChoice == 3)
        {
            d3.choose();
            return d3;
        }
        return null;
    }

    /**
     * Simulates the opening of one of the other doors once the player selected one.
     * It should  open a door chosen randomly among the ones that don't have the prize and
     * that are not selected by the player
     *
     *   @param prizeDoor the door that hides the prize
     *   @param selectedDoor the door that was selected by the player
     *   @return the door opened
     */


    private Door openOtherDoor(Door prizeDoor, Door selectedDoor)
    {
        //This block of if statements determines which door to open, as long as the door isn't chosen by the player, and it
        //doesn't contain the prize.

        if ((d2 == prizeDoor && d3 == selectedDoor) || (d3 == prizeDoor && d2 == selectedDoor))
        {
            return d1;
        }
        else if ((d3 == prizeDoor && d1 == selectedDoor) || (d1 == prizeDoor && d3 == selectedDoor))
        {
            return d2;
        }
        else if ((d1 == prizeDoor && d2 == selectedDoor) || (d2 == prizeDoor && d1 == selectedDoor))
        {
            return d3;
        }
        else if (d1 == prizeDoor && d1 == selectedDoor)
        {
            Random rand = new Random();
            int otherDoor = rand.nextInt(2) + 1;
            if (otherDoor == 1)
            {
                return d2;
            }
            else
            {
                return d3;
            }
        }
        else if (d2 == prizeDoor && d2 == selectedDoor)
        {
            Random rand = new Random();
            int otherDoor = rand.nextInt(2) + 1;
            if (otherDoor == 1)
            {
                return d1;
            }
            else
            {
                return d3;
            }
        }
        else if (d3 == prizeDoor && d3 == selectedDoor)
        {
            Random rand = new Random();
            int otherDoor = rand.nextInt(2) + 1;
            if (otherDoor == 1)
            {
                return d1;
            }
            else
            {
                return d2;
            }
        }

        return null;
    }

    /**
     * The main method of this program. Examples of the execution of the program
     * from the command line:
     * <pre>
     * > java MontyHall
     * The prize was behind door B
     * The player selected door B
     * The host opened door C
     * Switching strategy would have lost
     * </pre>
     * <pre>
     * > java MontyHall
     * The prize was behind door B
     * The player selected door A
     * The host opened door C
     * Switching strategy would have won
     * </pre>
     * @param args ignored for now
     */
    public static void main(String[] args)
    {

        MontyHall montyHall;
        montyHall = new MontyHall();
        Statistics stats = new Statistics();

        StudentInfo.display();
        int gamesToPlay = 0;

        //If no runtime arguments are detected, prompt the user, else use the given value as the number of games to be played
        if (args.length == 0)
        {
            gamesToPlay = Integer.parseInt(JOptionPane.showInputDialog("Please input the number of games to be played.", gamesToPlay));
        }
        else
        {
            gamesToPlay = Integer.parseInt(args[0]);
        }

        //Play as many games as the user requested
        for (int i = 0; i < gamesToPlay; i++)
        {
            montyHall.oneGame();
        }

        //Display the stats at the end of all games, and display a dialogbox containing the same stats
        System.out.println(stats);
        JOptionPane.showMessageDialog(null, stats.toString());

        try
        {
            FileWriter chart = new FileWriter("C:\\Users\\Ash\\Desktop\\output.csv");
            chart.append(stats.toCSV());

            chart.flush();
            chart.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}