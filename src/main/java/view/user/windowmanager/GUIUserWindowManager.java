package view.user.windowmanager;

import bean.BreedBean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import view.UserView;
import view.user.TestViewGraphicalController;
import view.user.factory.GUIFactory;
import view.user.factory.GraphicalFactory;
import view.user.testview.TestViewController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUIUserWindowManager extends UserWindowManager{

    static GUIUserWindowManager instance = null;
    private List<ToggleGroup> toggleList = new ArrayList<>();

    protected GUIUserWindowManager() {}

    public static GUIUserWindowManager getSingletonInstance() {
        if(instance == null){
            return new GUIUserWindowManager();
        }
        return instance;
    }

    @FXML
    private BorderPane bp;
    private Pane p;

    public void showTest(){

        GraphicalFactory factory = GraphicalFactory.getGraphicalSingletonFactory();
        TestViewController testView = factory.createTestViewController();
        testView.createTest();
    }

    /*public void getTestAnswers() throws URISyntaxException, IOException, InterruptedException {
        List<String> listOfAnswers = new ArrayList<>();
        for(ToggleGroup a: toggleList){

            RadioButton rb = (RadioButton) a.getSelectedToggle();
            listOfAnswers.add(rb.getText());
        }

        System.out.println(listOfAnswers);
        TestBean testAnswers = new TestBean(listOfAnswers);
        toggleList.clear();

        AdoptDogController presenter = new AdoptDogController(this);
        presenter.processTestAnswers(testAnswers);
        //it will call presenter.processTestAnswers
    }*/

    public void getBreedToSearch(){
        //it will call presenter.getDogsByBreed

    }

    public void getAllDogs(){
        loadPage("dogs-user-page");
        //it will call presenter.getDogsByBreed with empty params

    }

    public void showTestResult(BreedBean breedBean){

        GraphicalFactory factory = GraphicalFactory.getGraphicalSingletonFactory();
        TestViewController testView = factory.createTestViewController();
        testView.createTestResult(breedBean);
        //setCentralView(testResult);
        //this will be called by presenter to show the breed
    }

    public void showDogs(){
        //this will be called by presenter to show retrieves dogs

    }

    public void showDogAdoptionRequestForm(){
        //this will be used to show DAR form

    }

    public void getDogAdoptionRequestData(){
        //it will call presenter.sendDAR

    }

    public void loadPage(String page){
        Parent root = null;

        try{
            root = FXMLLoader.load(getClass().getClassLoader().getResource(page+".fxml"));

        }catch(IOException ex) {
            Logger.getLogger(UserWindowManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        bp.setCenter(root);
    }

    /*private ScrollPane createTestScrollPane() {
        // Layout per contenere tutte le domande
        VBox questionContainer = new VBox(30);
        questionContainer.setStyle("-fx-padding: 20px 20px 20px 20px;");
        questionContainer.setAlignment(Pos.CENTER);

        // Creazione delle domande e risposte
        for (int i = 0; i < TestQuestions.values().length; i++) {
            VBox singleQuestionBox = new VBox(10);

            Label questionLabel = new Label("Domanda " + i + ": "+TestQuestions.values()[i].getTesto());
            questionLabel.setStyle("-fx-font-size: 16px");

            ToggleGroup group = new ToggleGroup();
            toggleList.add(group);
            RadioButton option1 = new RadioButton("1");
            option1.setToggleGroup(group);
            RadioButton option2 = new RadioButton("2");
            option2.setToggleGroup(group);
            RadioButton option3 = new RadioButton("3");
            option3.setToggleGroup(group);
            RadioButton option4 = new RadioButton("4");
            option4.setToggleGroup(group);
            RadioButton option5 = new RadioButton("5");
            option5.setToggleGroup(group);

            HBox optionsBox = new HBox(10, option1, option2, option3, option4, option5);
            optionsBox.setAlignment(Pos.CENTER);
            optionsBox.setSpacing(20);
            singleQuestionBox.getChildren().addAll(questionLabel, optionsBox);

            questionContainer.getChildren().add(singleQuestionBox);
        }

        Button submitButton = new Button("SUBMIT");
        submitButton.setStyle("-fx-min-height: 40px; -fx-min-width: 400px; -fx-background-color:  #2cc61e; -fx-font-size: 20px;");
        submitButton.setOnAction(actionEvent -> {
            try {
                getTestAnswers();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        questionContainer.getChildren().add(submitButton);

        // ScrollPane per rendere il contenitore scrollabile
        ScrollPane scrollPane = new ScrollPane(questionContainer);
        scrollPane.setFitToWidth(true);

        // Creazione della scena con il questionario
        return scrollPane;
    }*/

    public void setCentralView(Pane centralView) {
        if(bp == null){
            throw new IllegalStateException("BorderPane not initialized");
        }
        bp.setCenter(centralView);
    }
}
