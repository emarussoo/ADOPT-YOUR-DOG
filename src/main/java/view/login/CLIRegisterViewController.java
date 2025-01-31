package view.login;
import exceptions.EmptyFieldsException;
import exceptions.GenericSystemException;
import exceptions.PasswordConfirmationException;
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

            if(kennelName.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                throw new EmptyFieldsException("One or more fields are empty");
            }

            if(!confirmPassword.equals(password)){
                throw new PasswordConfirmationException("The fields password and confirm password do not match");
            }
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
