package etml.app.meetapp.Controllers;

import android.os.AsyncTask;

import java.net.UnknownServiceException;

import etml.app.meetapp.Entities.EventEntity;
import etml.app.meetapp.Entities.UserEntity;
import etml.app.meetapp.Repositories.EventRepository;
import etml.app.meetapp.Repositories.UserRepository;
import etml.app.meetapp.database.ConnectMySQL;

public class LoginController{


    public void connect(String login, String pwd){
        AsyncConnect connect = new AsyncConnect();
        String params[] = {login, pwd};
        connect.doInBackground(params);
    }


    private class AsyncConnect extends AsyncTask<String, Void, Void> {

        private  UserEntity entity;

        protected Void doInBackground(String... params) {
            String login = params[0];
            String pwd = params[1];
            UserRepository  repository =  new UserRepository();
            entity =  repository.loginAttempt(login, pwd);
            return null;
        }

        protected void onPostExecute(Long result) {

        }
    }

    private class AsyncCreate extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... params) {
            //do stuff
            return null;
        }

        protected void onPostExecute(Long result) {

        }
    }
}
