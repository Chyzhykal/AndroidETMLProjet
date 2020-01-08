/**
 * ETML
 * Author :Aleh Chyzhk
 * Date : 11.12.2019
 * Description : objects storage class used to easily transfer data from one activity to another
 * Note : Java should have it's own storage for such situations, but developers did not have enough time to figure out the syntax
 */


package etml.app.meetapp.InterActivityObjects;

/**
 * objects storage class used to easily transfer data from one activity to another
 */
public class InterActivity {
    public static String accCreateInfo="";  // Account creation info
    public static int userId;               // Connected user id

    private static InterActivity instance;  // Instance of the object (due to being a singleton)

    /**
     * Private constructor
     */
    private  InterActivity(){}

    /**
     * Gets the singleton's instance
     * @return
     */
    public static InterActivity getInstance()
    {
        // Instantiate the object if it hasn't been done already
        if (instance == null)
        {
            // Create the instance
            instance = new InterActivity();
        }
        return instance;
    }
}
