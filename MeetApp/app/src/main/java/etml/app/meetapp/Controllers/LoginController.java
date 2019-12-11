package etml.app.meetapp.Controllers;

import etml.app.meetapp.Entities.UserEntity;
import etml.app.meetapp.Repositories.UserRepository;

public class LoginController implements Runnable{
    public static Thread connectThread = null;
    @Override
    public void run() {

    }

    public void connect(String name, String pwd){

        connectThread = new Thread() {
            public void run() {
                Communication communicationObject = new Communication();
                communicationObject.start();
            }
        };
       /* communicationThread = new Thread() {
            public void run() {
                Communication communicationObject = new Communication();
                communicationObject.start();
            }
        };

        communicationThread.start();
    }

    public static Thread getCommunicationThread() {
        if (communicationThread == null) { // init your Thread
        } return communicationThread;*/

        final String useName = name;
        final String usePwd = pwd;

        Thread thread =  new Thread(new Runnable() {
            public void run() {
                // a potentially time consuming task
                UserRepository repository= new UserRepository();
                final UserEntity userEntity = repository.loginAttempt(useName,usePwd);
            }
        }).start();


    }
}
