/**
 * ETML
 * Author :Aleh Chyzhk
 * Date : 11.12.2019
 * Description : objects storage class used to easily transer data from one activity to another
 * Note : Java should have it's own storage for such situations, but developers did not have enough time to figure out the syntax
 */


package etml.app.meetapp.InterActivityObjects;

// Class is a singleton
public class InterActivity {

        public static String accCreateInfo="";

        public static int userId;

        private  InterActivity(){

        }

        private static InterActivity instance;

        public static InterActivity getInstance()
        {
            if (instance == null)
            {
                // Create the instance
                instance = new InterActivity();
            }
            return instance;
        }
}
