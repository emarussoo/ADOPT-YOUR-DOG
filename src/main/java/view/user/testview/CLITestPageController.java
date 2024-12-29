package view.user.testview;

import bean.BreedBean;
import exceptions.GenericSystemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.TestQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class CLITestPageController extends TestPageController {
    private static final Logger logger = LogManager.getLogger(CLITestPageController.class.getName());
    @Override
    public void createTest(){
        for (int i = 0; i < TestQuestions.values().length; i++){
            logger.info("question {}: {}", i, TestQuestions.values()[i].getTesto());
        }
    }

    public List<String> getTestAnswers() throws URISyntaxException, IOException, InterruptedException {
        List<String> answersList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        logger.info("Insert answers");
        for (int i = 0; i < TestQuestions.values().length; i++){
            logger.info("question {}: {}", i, TestQuestions.values()[i].getTesto());
            try{
                String answer = reader.readLine();
                answersList.add(answer);
            }catch(Exception e){
                throw new GenericSystemException(e.getMessage());
            }
        }
        return answersList;
    }

    public void createTestResult(BreedBean breedBean){
        logger.info("Test result: ");
        logger.info("dog image link: {}", breedBean.getImageLink());
        logger.info("dog name: {}", breedBean.getName());
        logger.info("dog coat length: {}", breedBean.getCoatLength());
        logger.info("dog playfulness: {}", breedBean.getPlayfulness());
        logger.info("dog energy: {}", breedBean.getEnergy());
        logger.info("dog barking: {}", breedBean.getBarking());
        logger.info("dog protectiveness: {}", breedBean.getProtectiveness());
    }
}
