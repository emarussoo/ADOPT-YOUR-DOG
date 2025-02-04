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
import view.login.GUIRegisterViewController;
import view.login.LoginViewController;
import view.login.RegisterViewController;
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
    public TestPageController createTestPageController(){
        return new GUITestPageController();
    }

    @Override
    public DogsPageController createDogsPageController(){
        return new GUIDogsPageController();
    }

    public DogAdoptionRequestPageController createDogAdoptionRequestPageController(){
        return new GUIDogAdoptionRequestPageController();
    }




    @Override
    public LoginViewController createLoginPageController(){
        return GUILoginViewController.getSingletonInstance();
    }

    @Override
    public RegisterViewController createRegisterPageController(){
        return GUIRegisterViewController.getInstance();
    }




    @Override
    public KennelMenuController createKennelMenuController(){
        return GUIKennelMenuController.getSingletonInstance();
    }

    @Override
    public MyDogsPageController createMyDogsPageController(){
        return new GUIMyDogsPageController();
    }

    @Override
    public ManageDarPageController createManageDarPageController(){
        return new GUIManageDarPageController();
    }

    @Override
    public AddDogPageController createAddDogPageController(){
        return new GUIAddDogPageController();
    }


}
