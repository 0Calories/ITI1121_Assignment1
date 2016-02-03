package Q2;

/**
 * Created by Ash on 2/1/2016.
 */

/**
 * The class <b>Door</b> stores the information about one of the door:
 * does it have the prize behind it? Is it open or closed? Was it
 * selected by the player?
 *
 * It provides other objects access to these information through some
 * <b>setters</b> and <b>getters</b>.
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */
public class Door
{

    private boolean doorOpen;
    private boolean holdsPrize;
    private boolean chosen;
    private String name;


    /**
     * Creates an instance of the Door object.
     * Initially, the door is closed, doesn't have a prize behind it
     * and has not been chosen by the player.
     *
     * @param name identifier for that door
     */
    public Door(String name)
    {
        doorOpen = false;
        holdsPrize = false;
        chosen = false;
        this.name = name;
    }

    /**
     * Resets the door to its initial state: closed, without a prize behind it
     * and not chosen by the player.
     */
    public void reset()
    {
        doorOpen = false;
        holdsPrize = false;
        chosen = false;
    }

    /**
     * Sets this door open.
     */
    public void open()
    {
        doorOpen = true;
    }

    /**
     * Checks if the door is open.
     * @return true if the door is open
     */
    public boolean isOpen()
    {
        return doorOpen;
    }

    /**
     * Puts the prize behind this door.
     */
    public void setPrize()
    {
        holdsPrize = true;
    }

    /**
     * Checks if the door has the prize.
     * @return true if the door has the prize
     */
    public boolean hasPrize()
    {
        return holdsPrize;
    }

    /**
     * Sets this door as selected by the player.
     */
    public void choose()
    {
        chosen = true;
    }

    /**
     * Checks if the door is selected by the player.
     * @return true if the door is selected by the player
     */
    public boolean isChosen()
    {
        return chosen;
    }


    /**
     * @return the door's identifier
     */
    public String getName()
    {
        return name;
    }
}
