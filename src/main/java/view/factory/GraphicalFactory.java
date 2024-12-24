package view.factory;

import view.kennel.addadogview.AddDogPageController;
import view.kennel.managedogadoptionrequestview.ManageDarPageController;
import view.kennel.mydogsview.MyDogsPageController;
import view.kennel.windowmanager.KennelMenuController;
import view.login.LoginViewController;
import view.user.dogadoptionrequestview.DogAdoptionRequestPageController;
import view.user.dogspageview.DogsPageController;
import view.user.testview.TestPageController;
import view.user.windowmanager.UserMenuController;

public abstract class GraphicalFactory {

    private static GraphicalFactory instance = null;

    protected GraphicalFactory(){
    }

    public abstract UserMenuController createUserMenuController();
    public abstract TestPageController createTestViewController();
    public abstract DogsPageController createDogsPageController();
    public abstract DogAdoptionRequestPageController createDogAdoptionRequestController();
    public abstract LoginViewController createLoginPageController();
    public abstract KennelMenuController createKennelMenuController();


    public abstract MyDogsPageController createMyDogsPageController();
    public abstract ManageDarPageController createManageDarPageController();
    public abstract AddDogPageController createAddDogPageController();
    //singleton
    public static synchronized GraphicalFactory getGraphicalSingletonFactory(){
        if(instance == null){
            if(System.getProperty("user_choice").equals("GUI")){
                instance = new GUIFactory();
            }

            if(System.getProperty("user_choice").equals("CLI")){
                instance = new CLIFactory();
            }
        }
        return instance;
    }

}
