package view.kennel.windowmanager;

import bean.DogProfileBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.login.LoginManager;
import view.user.windowmanager.CLIUserMenuController;

import java.io.BufferedReader;
import java.io.IOException;

public class CLIKennelMenuController extends KennelMenuController{
    private static final Logger logger = LogManager.getLogger(CLIKennelMenuController.class.getName());
    public void show() {
        while(true) {
            logger.info("=====================Kennel Menu=====================");
            logger.info("1. add dog");
            logger.info("2. show my dars");
            logger.info("3. my dogs");
            logger.info("4. accept a dar");
            logger.info("5. reject a dar");
            logger.info("6. logout");

            BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
            try{
                int option = Integer.parseInt(reader.readLine());
                switch(option){
                    case 1:
                        addDog();
                        break;
                    case 2:
                        showDars();
                        break;
                    case 3:
                        myDogs();
                        break;
                    case 4:
                        acceptDar();
                        break;
                    case 5:
                        rejectDar();
                        break;
                    case 6:
                        logout();
                        break;

                    default:
                        break;

                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


    @Override
    public void addDog(){
        KennelWindowManager.getSingletonInstance().submitAdd();
    }
    public void myDogs(){
        KennelWindowManager.getSingletonInstance().showMyDogs();
    }

    public void showDars(){
        KennelWindowManager.getSingletonInstance().showMyDars();
    }

    public void acceptDar(){
        KennelWindowManager.getSingletonInstance().acceptDar();
    }

    public void rejectDar(){
        KennelWindowManager.getSingletonInstance().rejectDar();
    }

    public void logout(){
        LoginManager.getSingletonInstance().logout();
    }

}

