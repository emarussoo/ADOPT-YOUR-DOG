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
            logger.info("1. prova");
            logger.info("2. my dogs");
            logger.info("3. show dars");
            logger.info("4. accept a dar");
            logger.info("5. reject a dar");
            logger.info("6. logout");

            BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
            try{
                int option = Integer.parseInt(reader.readLine());
                switch(option){
                    case 1:
                        break;
                    case 2:
                        myDogs();
                        break;
                    case 3:
                        showDars();
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

