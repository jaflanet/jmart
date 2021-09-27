package jonaJmartBO;


/**
 * Write a description of class Transaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract interface Transactor
{
    public boolean validate();
    public Invoice perform();
}
