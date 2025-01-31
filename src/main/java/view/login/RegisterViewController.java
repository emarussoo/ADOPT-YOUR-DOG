package view.login;
import utils.GraphicalController;
import java.util.List;

public abstract class RegisterViewController implements GraphicalController {
    public abstract List<String> getRegisterCredentials();
    public abstract void showErrorMessage(String message);
}
