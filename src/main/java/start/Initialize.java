package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Initialize
{
    public Initialize(){
        //costruttore
    }

    public void init(){
        int choice;
        System.out.println("SCEGLI LA MODALITA' GRAFICA:");
        System.out.println("1. GUI");
        System.out.println("2. CLI");
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
            System.setProperty("persistence", "DEMO");

        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
