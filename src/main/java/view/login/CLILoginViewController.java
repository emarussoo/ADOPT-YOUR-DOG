package view.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.user.windowmanager.UserWindowManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CLILoginViewController extends LoginViewController{
    private static final Logger logger = LogManager.getLogger(CLILoginViewController.class.getName());
    @Override
    public void backToUserPage() {
        UserWindowManager.getSingletonInstance().show();
    }

    @Override
    public List<String> getLoginCredentials(){
        List<String> credentials = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        String username;
        String password;
        try{
            logger.info("Inserisci username: ");
            username = reader.readLine();
            logger.info("Inserisci password: ");
            password = reader.readLine();
            credentials.add(username);
            credentials.add(password);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return credentials;
    }

    public void showErrorMessage(String message){
        logger.info(message);
    }

}
