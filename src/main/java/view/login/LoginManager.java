package view.login;

import bean.LoginBean;
import exceptions.EmptyFieldsException;
import exceptions.GenericSystemException;
import exceptions.IncorrectCredentialsException;
import exceptions.PasswordConfirmationException;
import model.kennel.Kennel;
import model.login.KennelUser;
import controller.LogInController;
import view.factory.GraphicalFactory;
import view.kennel.windowmanager.KennelWindowManager;

import java.util.List;

public class LoginManager {
    private KennelWindowManager kennelWindowManager = KennelWindowManager.getSingletonInstance();
    private LoginViewController loginViewController = GraphicalFactory.getGraphicalSingletonFactory().createLoginPageController();
    private RegisterViewController registerViewController = GraphicalFactory.getGraphicalSingletonFactory().createRegisterPageController();

    private static LoginManager instance = null;

    protected LoginManager() {

    }

    public static LoginManager getSingletonInstance(){
        if(instance == null){
            instance = new LoginManager();
        }
        return instance;
    }

    public void authenticate() {
        try {
            List<String> credentials = loginViewController.getLoginCredentials();
            LoginBean loginBean = new LoginBean(credentials.get(0), credentials.get(1));
            LogInController logInController = new LogInController();
            logInController.auth(loginBean);
            kennelWindowManager.show();
        }catch(EmptyFieldsException | IncorrectCredentialsException e){
            loginViewController.showErrorMessage(e.getMessage());
        }
    }

    public void register() throws GenericSystemException {
        try {
            List<String> credentials = registerViewController.getRegisterCredentials();
            String kennelName = credentials.get(0);
            Kennel kennel = new Kennel(kennelName);

            String username = credentials.get(1);
            String password = credentials.get(2);
            KennelUser newUser = new KennelUser(username, password);
            LogInController logInController = new LogInController();
            logInController.ultimateRegistration(kennel, newUser);
            loginViewController.backToUserPage();
        }catch(EmptyFieldsException | PasswordConfirmationException e){
            registerViewController.showErrorMessage(e.getMessage());
        }
    }

    public void logout(){
        loginViewController.backToUserPage();
    }

    public RegisterViewController getRegisterViewController() {
        return registerViewController;
    }
}
