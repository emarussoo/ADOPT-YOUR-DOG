package view.user.windowmanager;

import bean.BreedBean;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.user.factory.GraphicalFactory;
import view.user.testview.TestViewController;

import java.io.BufferedReader;
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

    public void show(){
        while(true){
            System.out.println("=====================Menu=====================");
            System.out.println("Enter an option:");
            System.out.println("1.Take test");
            System.out.println("2. Show dogs list");
            System.out.println("3. Search dogs by breed");

            BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
            try{
                int option = Integer.parseInt(reader.readLine());
                switch(option){
                    case 1:
                        this.showTest();
                        GraphicalFactory.getGraphicalSingletonFactory().createTestViewController().submitTest();
                        break;
                    case 2:
                        this.getAllDogs();
                        break;
                    case 3:
                        this.getBreedToSearch();
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    };
    public void showTest(){
        TestViewController testView = GraphicalFactory.getGraphicalSingletonFactory().createTestViewController();
        testView.createTest();
    };
    public void getBreedToSearch(){};
    public void getAllDogs(){};
    public void showTestResult(BreedBean breedBean){
        GraphicalFactory.getGraphicalSingletonFactory().createTestViewController().createTestResult(breedBean);
    };
    public void setCentralView(Pane centralView){};
}
