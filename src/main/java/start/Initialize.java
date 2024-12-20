package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Initialize
{
    public Initialize(){}

    public void init(){
        int choice;
        System.out.println("SCEGLI LA MODALITA' GRAFICA:");
        System.out.println("1. GUI");
        System.out.println("2. CLI");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            choice = Integer.parseInt(reader.readLine());
            switch(choice){
                case 1:
                    System.setProperty("user_choice", "GUI");
                    break;
                    case 2:
                        System.setProperty("user_choice", "CLI");
                        break;
                        default:
                            System.setProperty("user_choice", "GUI");
                            break;
            }
            System.setProperty("persistence", "DEMO");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
