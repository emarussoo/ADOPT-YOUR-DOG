package view.user.testview;

import bean.BreedBean;
import utils.TestQuestions;
import view.user.windowmanager.WindowManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class CLITestViewController extends TestViewController{
    @Override
    public void createTest(){
        for (int i = 0; i < TestQuestions.values().length; i++){
            System.out.println("Domanda " + i + ": "+TestQuestions.values()[i].getTesto());
        }
    }

    public void submitTest() throws URISyntaxException, IOException, InterruptedException{
        WindowManager.getSingletonInstance().submitTest();
    }

    public List<String> getTestAnswers() throws URISyntaxException, IOException, InterruptedException {
        List<String> answersList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        System.out.println("=====================Inserisci risposte=====================");
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
        System.out.println("=====================Test result=====================");
        System.out.println("dog image link: " + breedBean.getImageLink());
        System.out.println("dog name: " + breedBean.getName());
        System.out.println("dog coat length: " + breedBean.getCoatLength());
        System.out.println("dog playfulness: " + breedBean.getPlayfulness());
        System.out.println("dog energy: " + breedBean.getEnergy());
        System.out.println("dog barking: " + breedBean.getBarking());
        System.out.println("dog protectiveness: " + breedBean.getProtectiveness());
    }
}
