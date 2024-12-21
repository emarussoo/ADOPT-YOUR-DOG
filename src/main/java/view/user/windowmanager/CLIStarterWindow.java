package view.user.windowmanager;

import bean.DogProfileBean;
import javafx.scene.layout.Pane;

import java.io.BufferedReader;
import java.util.List;

public class CLIStarterWindow extends StarterWindow {

    static CLIStarterWindow instance = null;

    protected CLIStarterWindow() {}

    public static CLIStarterWindow getSingletonInstance() {
        if(instance == null){
            return new CLIStarterWindow();
        }
        return instance;
    }

    public void show(){
        while(true){
            System.out.println("=====================Menu=====================");
            System.out.println("Enter an option:");
            System.out.println("1. Take test");
            System.out.println("2. Show dogs list");
            System.out.println("3. Search dogs by breed");
            System.out.println("4. Send dog adoption request");

            BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
            try{
                int option = Integer.parseInt(reader.readLine());
                switch(option){
                    case 1:
                        showTest();
                        submitTest();
                        break;
                    case 2:
                        showDogs();
                        break;
                    case 3:
                        submitSearch();
                        break;
                    case 4:
                        showDogAdoptionRequest();

                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    };

    public void showTest(){
        WindowManager.getSingletonInstance().showTest();
    }

    public void submitTest(){
        WindowManager.getSingletonInstance().submitTest();
    }

    public void submitSearch(){
        List<DogProfileBean> toFilterList = WindowManager.getSingletonInstance().getAllDogs();
        WindowManager.getSingletonInstance().submitSearch(toFilterList);

    }

    public void showDogs(){
        WindowManager.getSingletonInstance().showAllDogs();
    }

    public void showDogAdoptionRequest(){
        WindowManager.getSingletonInstance().showDogAdoptionRequestForm();
    }



}
