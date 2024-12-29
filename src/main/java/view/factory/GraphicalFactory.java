package view.factory;

import exceptions.GenericSystemException;
import view.kennel.addadogview.AddDogPageController;
import view.kennel.managedogadoptionrequestview.ManageDarPageController;
import view.kennel.mydogsview.MyDogsPageController;
import view.kennel.windowmanager.KennelMenuController;
import view.login.LoginViewController;
import view.login.RegisterViewController;
import view.user.dogadoptionrequestview.DogAdoptionRequestPageController;
import view.user.dogspageview.DogsPageController;
import view.user.testview.TestPageController;
import view.user.windowmanager.UserMenuController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class GraphicalFactory {

    private static GraphicalFactory instance = null;

    protected GraphicalFactory(){
    }

    public abstract UserMenuController createUserMenuController();
    public abstract TestPageController createTestViewController();
    public abstract DogsPageController createDogsPageController();
    public abstract DogAdoptionRequestPageController createDogAdoptionRequestController();
    public abstract LoginViewController createLoginPageController();
    public abstract RegisterViewController createRegisterPageController();
    public abstract KennelMenuController createKennelMenuController();


    public abstract MyDogsPageController createMyDogsPageController();
    public abstract ManageDarPageController createManageDarPageController();
    public abstract AddDogPageController createAddDogPageController();
    //singleton
    public static synchronized GraphicalFactory getGraphicalSingletonFactory() throws GenericSystemException {
        Properties prop = new Properties();

        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            prop.load(fis);
            if(instance == null){
                if(prop.getProperty("user_choice").equals("GUI")){
                    instance = new GUIFactory();
                }

                if(prop.getProperty("user_choice").equals("CLI")){
                    instance = new CLIFactory();
                }
            }
        } catch (FileNotFoundException e) {
            throw new GenericSystemException(e.getMessage());
        } catch (IOException e) {
            throw new GenericSystemException(e.getMessage());
        }
        return instance;
    }

}
