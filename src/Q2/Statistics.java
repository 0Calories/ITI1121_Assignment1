package Q2;

/**
 * Created by Ash on 2/3/2016.
 */

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

    int gamesPlayed;
    int switchSuccess;
    int switchFail;

    int doorAPrize;
    int doorBPrize;
    int doorCPrize;

    int doorAChosen;
    int doorBChosen;
    int doorCChosen;

    int doorAOpened;
    int doorBOpened;
    int doorCOpened;


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
// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

    }

    /**
     * Updates statistics for one single door.
     *   @param door the door for which statistics are updated
     *   @param index index of that door (0, 1 or 2)
     */
    private void oneDoor(Door door, int index)
    {
        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

    }

    /**
     *  @return Returns the complete statistics information
     */
    public String toString()
    {
        // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

    }

}