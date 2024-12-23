package view.user.windowmanager;

import bean.DogProfileBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.login.LoginManager;

import java.io.BufferedReader;
import java.util.List;

public class CLIUserMenuController extends UserMenuController {
    private static final Logger logger = LogManager.getLogger(CLIUserMenuController.class.getName());

    //static CLIUserMenuController instance = null;

    public CLIUserMenuController() {}

    /*public static CLIUserMenuController getSingletonInstance() {
        if(instance == null){
            return new CLIUserMenuController();
        }
        return instance;
    }*/

    public void show(){
        while(true){
            logger.info("=====================User Menu=====================");
            logger.info("Enter an option:");
            logger.info("1. Take test");
            logger.info("2. Show dogs list");
            logger.info("3. Search dogs by breed");
            logger.info("4. Send dog adoption request");
            logger.info("5. Login");

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
                        DogProfileBean dogProfileBean = showDogAdoptionRequest();
                        sendDogAdoptionRequest(dogProfileBean);
                        break;
                    case 5:
                        login();
                    default:
                        break;

                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void showTest(){
        UserWindowManager.getSingletonInstance().showTest();
    }

    public void submitTest(){
        UserWindowManager.getSingletonInstance().submitTest();
    }

    public void submitSearch(){
        List<DogProfileBean> toFilterList = UserWindowManager.getSingletonInstance().getAllDogs();
        UserWindowManager.getSingletonInstance().submitSearch(toFilterList);

    }

    public void showDogs(){
        UserWindowManager.getSingletonInstance().showAllDogs();
    }

    public DogProfileBean showDogAdoptionRequest(){
        return UserWindowManager.getSingletonInstance().showDogAdoptionRequestForm();
    }

    public void sendDogAdoptionRequest(DogProfileBean dogProfileBean){
        UserWindowManager.getSingletonInstance().sendDogAdoptionRequest(dogProfileBean);
    }

    public void login(){
        LoginManager.getSingletonInstance().authenticate();
    }



}
