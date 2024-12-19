package view.user.factory;

import view.user.dogspageview.DogsPageController;
import view.user.testview.TestViewController;
import view.user.windowmanager.UserWindowManager;

public abstract class GraphicalFactory {

    private static GraphicalFactory instance = null;

    protected GraphicalFactory(){
    };

    public abstract UserWindowManager createUserWindowManager();
    public abstract TestViewController createTestViewController();
    public abstract DogsPageController createDogsPageController();

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
