/**
 * ETML
 * Author :Aleh Chyzhk
 * Date : 11.12.2019
 * Description : objects storage class used to easily transer data from one activity to another
 */


package etml.app.meetapp.InterActivityObjects;

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
