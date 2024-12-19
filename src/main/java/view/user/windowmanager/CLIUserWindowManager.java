package view.user.windowmanager;

import bean.BreedBean;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class CLIUserWindowManager extends UserWindowManager{

    static CLIUserWindowManager instance = null;

    protected CLIUserWindowManager() {}

    public static CLIUserWindowManager getSingletonInstance() {
        if(instance == null){
            return new CLIUserWindowManager();
        }
        return instance;
    }

    public void showTest(){};
    public void getBreedToSearch(){};
    public void getAllDogs(){};
    public void showTestResult(BreedBean breedBean){};
    public void setCentralView(Pane centralView){};
}
