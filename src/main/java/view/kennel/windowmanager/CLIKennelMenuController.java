package view.kennel.windowmanager;

import exceptions.GenericSystemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.login.LoginManager;

import java.io.BufferedReader;

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
                        showDogAdoptionRequest();
                        break;
                    case 3:
                        showMyDogs();
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
                throw new GenericSystemException(e.getMessage());
            }
        }
    }


    @Override
    public void addDog(){
        KennelWindowManager.getSingletonInstance().submitAdd();
    }
    public void showMyDogs(){
        KennelWindowManager.getSingletonInstance().showMyDogs();
    }

    public void showDogAdoptionRequest(){
        KennelWindowManager.getSingletonInstance().showMyDars();
    }

    private void acceptDar(){
        KennelWindowManager.getSingletonInstance().acceptDar();
    }

    private void rejectDar(){
        KennelWindowManager.getSingletonInstance().rejectDar();
    }

    public void logout(){
        LoginManager.getSingletonInstance().logout();
    }

}

