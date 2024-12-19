package view.user.factory;

import view.user.dogspageview.CLIDogsPageController;
import view.user.dogspageview.DogsPageController;
import view.user.testview.CLITestViewController;
import view.user.testview.TestViewController;
import view.user.windowmanager.CLIStarterWindow;
import view.user.windowmanager.StarterWindow;

public class CLIFactory extends GraphicalFactory{
    @Override
    public StarterWindow createStarterWindow(){
        return CLIStarterWindow.getSingletonInstance();
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
