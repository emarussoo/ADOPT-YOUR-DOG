package view.user.factory;

import view.user.dogadoptionrequestview.DogAdoptionRequestController;
import view.user.dogadoptionrequestview.GUIDogAdoptionRequestController;
import view.user.dogspageview.DogsPageController;
import view.user.dogspageview.GUIDogsPageController;
import view.user.testview.GUITestViewController;
import view.user.testview.TestViewController;
import view.user.windowmanager.GUIUserMenuController;
import view.user.windowmanager.UserMenuController;

public class GUIFactory extends GraphicalFactory{
    @Override
    public UserMenuController createUserMenuController(){
        return GUIUserMenuController.getSingletonInstance();
    }

    @Override
    public TestViewController createTestViewController(){
        return new GUITestViewController();
    }

    @Override
    public DogsPageController createDogsPageController(){
        return new GUIDogsPageController();
    }

    public DogAdoptionRequestController createDogAdoptionRequestController(){
        return new GUIDogAdoptionRequestController();
    }


}
