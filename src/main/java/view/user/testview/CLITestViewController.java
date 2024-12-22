package view.user.testview;

import bean.BreedBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.TestQuestions;
import view.user.dogspageview.CLIDogsPageController;
import view.user.windowmanager.WindowManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class CLITestViewController extends TestViewController{
    private static final Logger logger = LogManager.getLogger(CLITestViewController.class.getName());
    @Override
    public void createTest(){
        for (int i = 0; i < TestQuestions.values().length; i++){
            logger.info("Domanda " + i + ": "+TestQuestions.values()[i].getTesto());
        }
    }

    public void submitTest() throws URISyntaxException, IOException, InterruptedException{
        WindowManager.getSingletonInstance().submitTest();
    }

    public List<String> getTestAnswers() throws URISyntaxException, IOException, InterruptedException {
        List<String> answersList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        logger.info("=====================Inserisci risposte=====================");
        for (int i = 0; i < TestQuestions.values().length; i++){
            System.out.print("domanda " + i + ": ");
            try{
                String answer = reader.readLine();
                answersList.add(answer);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return answersList;
    }

    public void createTestResult(BreedBean breedBean){
        logger.info("=====================Test result=====================");
        logger.info("dog image link: {}", breedBean.getImageLink());
        logger.info("dog name: {}", breedBean.getName());
        logger.info("dog coat length: {}", breedBean.getCoatLength());
        logger.info("dog playfulness: {}", breedBean.getPlayfulness());
        logger.info("dog energy: {}", breedBean.getEnergy());
        logger.info("dog barking: {}", breedBean.getBarking());
        logger.info("dog protectiveness: {}", breedBean.getProtectiveness());
    }
}
