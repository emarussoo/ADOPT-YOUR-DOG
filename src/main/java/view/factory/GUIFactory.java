package view.factory;

import view.kennel.addadogview.AddDogPageController;
import view.kennel.addadogview.GUIAddDogPageController;
import view.kennel.managedogadoptionrequestview.GUIManageDarPageController;
import view.kennel.managedogadoptionrequestview.ManageDarPageController;
import view.kennel.mydogsview.GUIMyDogsPageController;
import view.kennel.mydogsview.MyDogsPageController;
import view.kennel.windowmanager.GUIKennelMenuController;
import view.kennel.windowmanager.KennelMenuController;
import view.login.GUILoginViewController;
import view.login.LoginViewController;
import view.user.dogadoptionrequestview.DogAdoptionRequestPageController;
import view.user.dogadoptionrequestview.GUIDogAdoptionRequestPageController;
import view.user.dogspageview.DogsPageController;
import view.user.dogspageview.GUIDogsPageController;
import view.user.testview.GUITestPageController;
import view.user.testview.TestPageController;
import view.user.windowmanager.GUIUserMenuController;
import view.user.windowmanager.UserMenuController;

public class GUIFactory extends GraphicalFactory{
    @Override
    public UserMenuController createUserMenuController(){
        return GUIUserMenuController.getSingletonInstance();
    }

    @Override
    public TestPageController createTestViewController(){
        return new GUITestPageController();
    }

    @Override
    public DogsPageController createDogsPageController(){
        return new GUIDogsPageController();
    }

    public DogAdoptionRequestPageController createDogAdoptionRequestController(){
        return new GUIDogAdoptionRequestPageController();
    }

    @Override
    public LoginViewController createLoginPageController(){
        return GUILoginViewController.getSingletonInstance();
    }

    @Override
    public KennelMenuController createKennelMenuController(){
        return GUIKennelMenuController.getSingletonInstance();
    }

    public MyDogsPageController createMyDogsPageController(){
        return new GUIMyDogsPageController();
    }

    public ManageDarPageController createManageDarPageController(){
        return new GUIManageDarPageController();
    }

    public AddDogPageController createAddDogPageController(){
        return new GUIAddDogPageController();
    }


}
