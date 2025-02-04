package view.factory;
import view.kennel.addadogview.AddDogPageController;
import view.kennel.addadogview.CLIAddDogPageController;
import view.kennel.managedogadoptionrequestview.CLIManageDarPageController;
import view.kennel.managedogadoptionrequestview.ManageDarPageController;
import view.kennel.mydogsview.CLIMyDogsPageController;
import view.kennel.mydogsview.MyDogsPageController;
import view.kennel.windowmanager.CLIKennelMenuController;
import view.kennel.windowmanager.KennelMenuController;
import view.login.CLILoginViewController;
import view.login.CLIRegisterViewController;
import view.login.LoginViewController;
import view.login.RegisterViewController;
import view.user.dogadoptionrequestview.CLIDogAdoptionRequestPageController;
import view.user.dogadoptionrequestview.DogAdoptionRequestPageController;
import view.user.dogspageview.CLIDogsPageController;
import view.user.dogspageview.DogsPageController;
import view.user.testview.CLITestPageController;
import view.user.testview.TestPageController;
import view.user.windowmanager.CLIUserMenuController;
import view.user.windowmanager.UserMenuController;

public class CLIFactory extends GraphicalFactory{
    @Override
    public UserMenuController createUserMenuController(){
        return new CLIUserMenuController();
    }

    @Override
    public TestPageController createTestPageController(){
        return new CLITestPageController();
    }

    @Override
    public DogsPageController createDogsPageController(){
        return new CLIDogsPageController();
    }

    public DogAdoptionRequestPageController createDogAdoptionRequestPageController(){
        return new CLIDogAdoptionRequestPageController();
    }



    @Override
    public LoginViewController createLoginPageController(){
        return new CLILoginViewController();
    }

    @Override
    public RegisterViewController createRegisterPageController(){
        return new CLIRegisterViewController();
    }



    @Override
    public KennelMenuController createKennelMenuController(){
        return new CLIKennelMenuController();
    }

    @Override
    public MyDogsPageController createMyDogsPageController(){
        return new CLIMyDogsPageController();
    }

    @Override
    public ManageDarPageController createManageDarPageController(){
        return new CLIManageDarPageController();
    }

    @Override
    public AddDogPageController createAddDogPageController(){
        return new CLIAddDogPageController();
    }
}
