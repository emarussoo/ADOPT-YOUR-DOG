package view.login;

import view.GraphicalController;

import java.util.List;

public abstract class LoginViewController implements GraphicalController {
    public abstract void backToUserPage();
    public abstract List<String> getLoginCredentials();
    public abstract void showErrorMessage(String message);
}
