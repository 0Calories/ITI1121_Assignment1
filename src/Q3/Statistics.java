package Q3;

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

    private int gamesPlayed;
    private int switchSuccess;
    private int switchFail;

    private int doorAPrize;
    private int doorBPrize;
    private int doorCPrize;

    private int doorAChosen;
    private int doorBChosen;
    private int doorCChosen;

    private int doorAOpened;
    private int doorBOpened;
    private int doorCOpened;



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
        return "lol" + doorAChosen;



    }

    public String toCSV() {
        return "Number of games ,"+gamesPlayed+
                "\nNumber of doors, 3"+
                "\n,Win,Loss"+
                "\nStaying strategy ,"+switchFail+", "+switchSuccess+
                "\nSwitching strategy, "+switchSuccess+", "+switchFail+
                "\n, Selected doors, Winning doors, Open doors" +
                "\nDoor 1, "+doorAChosen+", "+doorAPrize+", "+doorAOpened+
                "\nDoor 2, "+doorBChosen+", "+doorBPrize+", "+doorBOpened+
                "\nDoor 3, "+doorCChosen+", "+doorCPrize+", "+doorCOpened;
    }

}