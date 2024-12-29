package view.kennel.addadogview;

import exceptions.EmptyFieldsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class CLIAddDogPageController extends AddDogPageController {
    private static final Logger logger = LogManager.getLogger(CLIAddDogPageController.class.getName());
    public void createAddForm(){
        logger.info("Stai inserendo un nuovo cane che sarà possibile adottare");
    }

    public List<String> getDogInfo() throws EmptyFieldsException {
        List<String> dogInfo = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        logger.info("Inserisci i dati del cane");
        try {
            logger.info("Nome del cane:");
            String dogName = reader.readLine();
            dogInfo.add(dogName);
            logger.info("Eta del cane:");
            String dogAge = reader.readLine();
            dogInfo.add(dogAge);
            logger.info("Razza del cane:");
            String dogBreed = reader.readLine();
            dogInfo.add(dogBreed);
            if(dogName.equals("")||dogAge.equals("")||dogBreed.equals("")){
                throw new EmptyFieldsException("Uno o più campi sono vuoti");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dogInfo;
    }

    public void createMessage(String message){
        logger.info(message);
    }
}
