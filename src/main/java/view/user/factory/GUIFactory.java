package view.user.factory;

import view.user.dogspageview.DogsPageController;
import view.user.dogspageview.GUIDogsPageController;
import view.user.testview.GUITestViewController;
import view.user.testview.TestViewController;
import view.user.windowmanager.GUIUserWindowManager;
import view.user.windowmanager.UserWindowManager;

public class GUIFactory extends GraphicalFactory{
    @Override
    public UserWindowManager createUserWindowManager(){
        return GUIUserWindowManager.getSingletonInstance();
    }

    @Override
    public TestViewController createTestViewController(){
        return new GUITestViewController();
    }

    @Override
    public DogsPageController createDogsPageController(){
        return new GUIDogsPageController();
    }


}
