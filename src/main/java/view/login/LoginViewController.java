package view.login;

import bean.LoginBean;
import start.GraphicalController;

import java.util.List;

public abstract class LoginViewController extends GraphicalController {
    public abstract void backToUserPage();
    public abstract List<String> getCredentials();
    public abstract void showKennelPage();

}
