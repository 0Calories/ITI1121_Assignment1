package Q3;

import java.text.DecimalFormat;

/**
 * The class  <b>Statistics</b> accumulates information about a series of games:
 * <ol>
 * <li>Number of game played</li>
 * <li>Number of times the switching strategy was successful</li>
 * <li>Number of times the switching strategy was not successful</li>
 * <li>Number of times each door has the prize behind it</li>
 * <li>Number of times each door was chosen by the player</li>
 * <li>Number of times each door was open by the host</li>
 * </ol>
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */
public class Statistics
{

    private static int gamesPlayed;
    private static int switchSuccess;
    private static int switchFail;

    private static int doorAPrize;
    private static int doorBPrize;
    private static int doorCPrize;

    private static int doorAChosen;
    private static int doorBChosen;
    private static int doorCChosen;

    private static int doorAOpened;
    private static int doorBOpened;
    private static int doorCOpened;



    /**
     * Initializes the statistics.
     */
    public Statistics()
    {
        gamesPlayed = 0;
        switchSuccess = 0;
        switchFail = 0;

        doorAPrize = 0;
        doorBPrize = 0;
        doorCPrize = 0;

        doorAChosen = 0;
        doorBChosen = 0;
        doorCChosen = 0;

        doorAOpened = 0;
        doorBOpened = 0;
        doorCOpened = 0;



    }

    /**
     * Updates statistics after one game.
     *   @param door1 the first door in the game
     *   @param door2 the second door in the game
     *   @param door3 the third door in the game
     */
    public void updateStatistics(Door door1, Door door2, Door door3)
    {
        //Add 1 to the games played counter, and update the stats for each door by calling the oneDoor method
        gamesPlayed += 1;
        oneDoor(door1, 1);
        oneDoor(door2, 2);
        oneDoor(door3, 3);

    }

    /**
     * Updates statistics for one single door.
     *   @param door the door for which statistics are updated
     *   @param index index of that door (0, 1 or 2)
     */
    private void oneDoor(Door door, int index)
    {
        //Determine which variables to update, based on the given index of the door, and determine whether switching would have failed or succeeded.
        if (index == 1)
        {
            if (door.isChosen())
            {
                doorAChosen += 1;
                if (door.hasPrize())
                {
                    switchFail += 1; //Since this door has the prize, if the player switched doors, they would lose.
                }
                else
                {
                    switchSuccess += 1; //Since this door does not have the prize, the player would win if they switched.
                }
            }
            if (door.hasPrize())
            {
                doorAPrize += 1;
            }
            if (door.isOpen())
            {
                doorAOpened += 1;
            }
        }

        if (index == 2)
        {
            if (door.isChosen())
            {
                doorBChosen += 1;
                if (door.hasPrize())
                {
                    switchFail += 1; //Since this door has the prize, if the player switched doors, they would lose.
                }
                else
                {
                    switchSuccess += 1; //Since this door does not have the prize, the player would win if they switched.
                }
            }
            if (door.hasPrize())
            {
                doorBPrize += 1;
            }
            if (door.isOpen())
            {
                doorBOpened += 1;
            }
        }

        if (index == 3)
        {
            if (door.isChosen())
            {
                doorCChosen += 1;
                if (door.hasPrize())
                {
                    switchFail += 1; //Since this door has the prize, if the player switched doors, they would lose.
                }
                else
                {
                    switchSuccess += 1; //Since this door does not have the prize, the player would win if they switched.
                }
            }
            if (door.hasPrize())
            {
                doorCPrize += 1;
            }
            if (door.isOpen())
            {
                doorCOpened += 1;
            }
        }

    }


    /**
     *  @return Returns the complete statistics information
     */
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("#");

        return "Number of games played: " + gamesPlayed + "\n" +
                "Staying strategy won " + switchFail + " games " + " (" + df.format(((float)(switchFail) / ((float)(switchFail + switchSuccess)) * 100)) + "%)\n" +
                "Switching strategy won " + switchSuccess + " games " + " (" + df.format(((float)(switchSuccess) / ((float)(switchFail + switchSuccess)) * 100)) + "%)\n" +
                "Selected doors:\n" +
                "   door 1: " + doorAChosen + " (" + df.format(((float)(doorAChosen) / ((float)(doorAChosen + doorBChosen + doorCChosen)) * 100)) + "%)\n" +
                "   door 2: " + doorBChosen + " (" + df.format(((float)(doorBChosen) / ((float)(doorAChosen + doorBChosen + doorCChosen)) * 100)) + "%)\n" +
                "   door 3: " + doorCChosen + " (" + df.format(((float)(doorCChosen) / ((float)(doorAChosen + doorBChosen + doorCChosen)) * 100)) + "%)\n" +
                "Winning doors:\n" +
                "   door 1: " + doorAPrize + " (" + df.format(((float)(doorAPrize) / ((float)(doorAPrize + doorBPrize + doorCPrize)) * 100)) + "%)\n" +
                "   door 2: " + doorBPrize + " (" + df.format(((float)(doorBPrize) / ((float)(doorAPrize + doorBPrize + doorCPrize)) * 100)) + "%)\n" +
                "   door 3: " + doorCPrize + " (" + df.format(((float)(doorCPrize) / ((float)(doorAPrize + doorBPrize + doorCPrize)) * 100)) + "%)\n" +
                "Open doors:\n" +
                "   door 1: " + doorAOpened + " (" + df.format(((float)(doorAOpened) / ((float)(doorAOpened + doorBOpened + doorCOpened)) * 100)) + "%)\n" +
                "   door 2: " + doorBOpened + " (" + df.format(((float)(doorBOpened) / ((float)(doorAOpened + doorBOpened + doorCOpened)) * 100)) + "%)\n" +
                "   door 3: " + doorCOpened + " (" + df.format(((float)(doorCOpened) / ((float)(doorAOpened + doorBOpened + doorCOpened)) * 100)) + "%)\n";



    }

    /**
     *  @return Returns the complete statistics information in CSV format
     */
    public String toCSV()
    {

        return "Number of games," + gamesPlayed + "\n" +
                "Number of doors,3\n" +
                ",Win,Loss\n" +
                "Switching strategy," + switchSuccess + "," + switchFail + "\n" +
                "Staying strategy," + switchFail + "," + switchSuccess + "\n" +
                ",Selected doors,Winning doors,Open doors\n" +
                "Door1," + doorAChosen + "," + doorAPrize + "," + doorAOpened + "\n" +
                "Door2," + doorBChosen + "," + doorBPrize + "," + doorBOpened + "\n" +
                "Door3," + doorCChosen + "," + doorCPrize + "," + doorCOpened + "\n";


    }

}