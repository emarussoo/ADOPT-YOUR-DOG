package view.factory;

import view.login.CLILoginViewController;
import view.login.LoginViewController;
import view.user.dogadoptionrequestview.CLIDogAdoptionRequestController;
import view.user.dogadoptionrequestview.DogAdoptionRequestController;
import view.user.dogspageview.CLIDogsPageController;
import view.user.dogspageview.DogsPageController;
import view.user.testview.CLITestViewController;
import view.user.testview.TestViewController;
import view.user.windowmanager.CLIUserMenuController;
import view.user.windowmanager.UserMenuController;

public class CLIFactory extends GraphicalFactory{
    @Override
    public UserMenuController createUserMenuController(){
        return new CLIUserMenuController();
    }

    @Override
    public TestViewController createTestViewController(){
        return new CLITestViewController();
    }

    @Override
    public DogsPageController createDogsPageController(){
        return new CLIDogsPageController();
    }

    public DogAdoptionRequestController createDogAdoptionRequestController(){
        return new CLIDogAdoptionRequestController();
    }

    @Override
    public LoginViewController createLoginPageController(){
        return new CLILoginViewController();
    }
}
