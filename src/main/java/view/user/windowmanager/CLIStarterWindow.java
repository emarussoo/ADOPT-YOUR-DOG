package view.user.windowmanager;

import bean.DogProfileBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.util.List;

public class CLIStarterWindow extends StarterWindow {
    private static final Logger logger = LogManager.getLogger(CLIStarterWindow.class.getName());

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
            logger.info("=====================Menu=====================");
            logger.info("Enter an option:");
            logger.info("1. Take test");
            logger.info("2. Show dogs list");
            logger.info("3. Search dogs by breed");
            logger.info("4. Send dog adoption request");

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
                        break;
                    default:
                        break;

                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

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
