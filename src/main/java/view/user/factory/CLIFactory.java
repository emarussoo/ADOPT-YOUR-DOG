package view.user.factory;

import view.user.dogspageview.CLIDogsPageController;
import view.user.dogspageview.DogsPageController;
import view.user.testview.CLITestViewController;
import view.user.testview.TestViewController;
import view.user.windowmanager.CLIUserWindowManager;
import view.user.windowmanager.UserWindowManager;

public class CLIFactory extends GraphicalFactory{
    @Override
    public UserWindowManager createUserWindowManager(){
        return CLIUserWindowManager.getSingletonInstance();
    }

    @Override
    public TestViewController createTestViewController(){
        return new CLITestViewController();
    }

    @Override
    public DogsPageController createDogsPageController(){
        return new CLIDogsPageController();
    }
}
