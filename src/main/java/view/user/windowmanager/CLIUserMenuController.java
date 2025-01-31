package view.user.windowmanager;
import bean.DogProfileBean;
import exceptions.GenericSystemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.login.LoginManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;

public class CLIUserMenuController extends UserMenuController {
    private static final Logger logger = LogManager.getLogger(CLIUserMenuController.class.getName());

    public CLIUserMenuController() {
        //costruttore
    }

    public void show(){
        while(true){
            logger.info("=====================User Menu=====================");
            logger.info("Enter an option:");
            logger.info("1. Take test");
            logger.info("2. Show dogs list");
            logger.info("3. Search dogs by breed");
            logger.info("4. Send dog adoption request");
            logger.info("5. Login");
            logger.info("6. Register");

            BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
            try{
                int option = Integer.parseInt(reader.readLine());
                switch(option){
                    case 1:
                        showTest();
                        UserWindowManager.getSingletonInstance().submitTest();
                        break;
                    case 2:
                        showDogs();
                        break;
                    case 3:
                        UserWindowManager.getSingletonInstance().submitSearch();
                        break;
                    case 4:
                        DogProfileBean dogProfileBean = UserWindowManager.getSingletonInstance().showDogAdoptionRequestForm();
                        UserWindowManager.getSingletonInstance().sendDogAdoptionRequest(dogProfileBean);
                        break;
                    case 5:
                        login();
                        break;
                    case 6:
                        LoginManager.getSingletonInstance().register();
                        break;
                    default:
                        break;

                }

            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            } catch (IOException | URISyntaxException e) {
                throw new GenericSystemException(e.getMessage());
            }
        }
    }

    public void showTest(){
        UserWindowManager.getSingletonInstance().showTest();
    }

    public void showDogs(){
        UserWindowManager.getSingletonInstance().showAllDogs();
    }

    public void login(){
        LoginManager.getSingletonInstance().authenticate();
    }
}
