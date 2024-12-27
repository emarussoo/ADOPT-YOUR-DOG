package view.login;

import view.GraphicalController;

import java.util.List;

public abstract class RegisterViewController implements GraphicalController {
    public abstract List<String> getRegisterCredentials();
}
