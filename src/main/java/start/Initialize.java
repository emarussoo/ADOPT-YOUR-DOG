package start;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Initialize
{
    private static final Logger logger = LogManager.getLogger(Initialize.class.getName());
    public Initialize(){
        //costruttore
    }

    public void init(){
        int choice;
        logger.info("SCEGLI LA MODALITA' GRAFICA:");
        logger.info("1. GUI");
        logger.info("2. CLI");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String choiceProperty = "user_choice";
            choice = Integer.parseInt(reader.readLine());
            switch(choice){
                case 1:
                    System.setProperty(choiceProperty, "GUI");
                    break;
                    case 2:
                        System.setProperty(choiceProperty, "CLI");
                        break;
                        default:
                                System.setProperty(choiceProperty, "GUI");
                            break;
            }
            System.setProperty("persistence", "JDBC");

        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
