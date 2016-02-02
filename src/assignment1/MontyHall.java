package assignment1;
import java.util.Random;

/**
 * Created by Ash on 2/1/2016.
 */
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

    Door d1;
    Door d2;
    Door d3;

    /**
     * Initializes the three doors.
     */
    public MontyHall()
    {
        d1 = new Door("Door A");
        d2 = new Door("Door B");
        d3 = new Door("Door C");
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

        Door chosenDoor = pickADoor();
        System.out.println("The prize was behind " + prizeD.getName());
        System.out.println("The player chose " + chosenDoor.getName());

        Door openDoor = openOtherDoor(prizeD, chosenDoor);
        openDoor.open();
        System.out.println("The host opened " + openDoor.getName());

        //This block of if statements determines what is the proper choice for the host by finding which door hasn't been
        //chosen by the player and doesn't contain the prize


        if(chosenDoor.hasPrize())
        {
            System.out.println("Switching strategy would have lost");
        }
        else
        {
            System.out.println("Switching strategy would have won");
        }

    }

    /**
     * Simulates a random selection of one of the three doors.
     * @return the door randomly selected
     */
    //WORKING!
    private Door pickADoor()
    {
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

    //************************DEBUG THIS!****************
    private Door openOtherDoor(Door prizeDoor, Door selectedDoor)
    {
        //System.out.println(((d2 == prizeDoor && d3 == selectedDoor) || (d3 == prizeDoor && d2 == selectedDoor)));
        //System.out.println(((d3 == prizeDoor && d1 == selectedDoor) || (d1 == prizeDoor && d3 == selectedDoor)));
        //System.out.println(((d1 == prizeDoor && d2 == selectedDoor) || (d2 == prizeDoor && d1 == selectedDoor)));

        /*
        System.out.println(d2 == prizeDoor);
        System.out.println(d3 == selectedDoor);

        System.out.println();

        System.out.println(d3 == prizeDoor);
        System.out.println(d2 == selectedDoor);

        System.out.println();

        System.out.println(d3 == prizeDoor);
        System.out.println(d1 == selectedDoor);

        System.out.println();

        System.out.println(d1 == prizeDoor);
        System.out.println(d3 == selectedDoor);

        System.out.println();

        System.out.println(d1 == prizeDoor);
        System.out.println(d2 == selectedDoor);

        System.out.println();

        System.out.println(d2 == prizeDoor);
        System.out.println(d1 == selectedDoor);

        */

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

        StudentInfo.display();
        montyHall = new MontyHall();
        montyHall.oneGame();
    }

}