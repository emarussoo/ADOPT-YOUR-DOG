package view.user.factory;

import view.user.dogadoptionrequestview.DogAdoptionRequestController;
import view.user.dogspageview.DogsPageController;
import view.user.testview.TestViewController;
import view.user.windowmanager.StarterWindow;

public abstract class GraphicalFactory {

    private static GraphicalFactory instance = null;

    protected GraphicalFactory(){
    }

    public abstract StarterWindow createStarterWindow();
    public abstract TestViewController createTestViewController();
    public abstract DogsPageController createDogsPageController();
    public abstract DogAdoptionRequestController createDogAdoptionRequestController();

    //singleton
    public static GraphicalFactory getGraphicalSingletonFactory(){
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
