package view.login;

import exceptions.GenericSystemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CLIRegisterViewController extends RegisterViewController {
    private static final Logger logger = LogManager.getLogger(CLIRegisterViewController.class.getName());
    public List<String> getRegisterCredentials() throws GenericSystemException {
        List<String> credentials = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        String kennelName;
        String username;
        String password;
        String confirmPassword;

        try{
            logger.info("Inserisci nome canile");
            kennelName = reader.readLine();
            logger.info("Inserisci username: ");
            username = reader.readLine();
            logger.info("Inserisci password: ");
            password = reader.readLine();
            logger.info("Conferma password: ");
            confirmPassword = reader.readLine();
            credentials.add(kennelName);
            credentials.add(username);
            credentials.add(password);
            credentials.add(confirmPassword);
        } catch (IOException e) {
            throw new GenericSystemException(e.getMessage());
        }
        return credentials;

    }

    public void showErrorMessage(String message){
        logger.info(message);
    }
}
