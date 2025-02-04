package view.user.windowmanager;
import bean.*;
import exceptions.*;
import controller.AdoptDogController;
import view.user.dogadoptionrequestview.DogAdoptionRequestPageController;
import view.user.dogspageview.DogsPageController;
import view.factory.GraphicalFactory;
import view.user.testview.TestPageController;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class UserWindowManager {
    //graphical controllers
    private final TestPageController testPage = GraphicalFactory.getGraphicalSingletonFactory().createTestPageController();
    private final DogsPageController dogsPage = GraphicalFactory.getGraphicalSingletonFactory().createDogsPageController();
    private final DogAdoptionRequestPageController dogAdoptionRequestPage = GraphicalFactory.getGraphicalSingletonFactory().createDogAdoptionRequestPageController();
    private final UserMenuController userMenuController = GraphicalFactory.getGraphicalSingletonFactory().createUserMenuController();

    private static UserWindowManager instance = null;

    protected UserWindowManager() {
        //costruttore
    }

    //this shows the app menu
    public void show(){
        userMenuController.show();
    }

    //this shows the test
    public void showTest(){
        testPage.createTest();
    }

    //this will be called to get user test answers, process them and then call the method to show the test result
    public void submitTest() throws GenericSystemException, URISyntaxException, IOException, InterruptedException {
        try {
            List<String> listOfAnswers = testPage.getTestAnswers();
            TestBean testAnswers = new TestBean(listOfAnswers);
            AdoptDogController controller = new AdoptDogController();
            BreedBean resultBreed = controller.processTestAnswers(testAnswers);
            showTestResult(resultBreed);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (DogNotFoundException | InvalidBreedTestInput e){
            UserWindowManager.getSingletonInstance().getTestView().createMessage(e.getMessage());

        }
    }

    //this will be called to show the result of the test
    //it will call the graphical controller who is in charge to show the test result, so the testpage controller
    private void showTestResult(BreedBean breedBean){
        testPage.createTestResult(breedBean);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////


    //this will be called to get a breed and show the updated dogs list
    public void submitSearch(){
        String insertedBreed = dogsPage.getInsertedBreed();
        DogBreedSearchBean dogBreedSearchBean = new DogBreedSearchBean(insertedBreed);
        AdoptDogController controller = new AdoptDogController();
        List<DogProfileBean> filteredDogs = controller.getDogsByBreed(dogBreedSearchBean);
        showListOfDogs(filteredDogs);
    }

    //this will return the list of all dogs
    public List<DogProfileBean> getAllDogs(){
        AdoptDogController controller = new AdoptDogController();
        return controller.getAllDogs();
    }

    //this will show all the dogs
    public void showAllDogs(){
        List<DogProfileBean> allDogs = getAllDogs();
        showListOfDogs(allDogs);
    }

    //this will show the list of dogs that is passed by calling the specific graphical controller
    private void showListOfDogs(List<DogProfileBean> listOfDogs){
        dogsPage.createListOfDogs(listOfDogs);
    }

    //this will be called to print the dar form
    //it will also get the information about the dog that the user wants to adopt
    //it will call the method to show the form, but with pre-setted dog info
    public DogProfileBean  showDogAdoptionRequestForm(){
        DogProfileBean dogProfileBean = dogsPage.getDogInfo();
        dogAdoptionRequestPage.createDogAdoptionRequest(dogProfileBean);
        return dogProfileBean;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    //this will effectively add the dar
    public void sendDogAdoptionRequest(DogProfileBean dogProfileBean){
        try {
            List<String> dogAdoptionRequestUserInfo = dogAdoptionRequestPage.getUserInfo();
            String userNameBean = dogAdoptionRequestUserInfo.get(0);
            String userSurnameBean = dogAdoptionRequestUserInfo.get(1);
            String userEmailBean = dogAdoptionRequestUserInfo.get(2);
            String userPhoneBean = dogAdoptionRequestUserInfo.get(3);
            String dogIdBean = dogProfileBean.getDogId();
            String kennelIdBean = dogProfileBean.getKennelId();
            DogAdoptionRequestBean dogAdoptionRequestBean = new DogAdoptionRequestBean(userNameBean, userSurnameBean, userEmailBean, userPhoneBean, dogIdBean, kennelIdBean);

            AdoptDogController controller = new AdoptDogController();
            controller.sendDogAdoptionRequest(dogAdoptionRequestBean);
            dogAdoptionRequestPage.createMessage("Request sent");
        }catch(EmptyFieldsException | InvalidFieldException e){
            dogAdoptionRequestPage.createMessage(e.getMessage());
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////


    public TestPageController getTestView() {
        return testPage;
    }

    public DogsPageController getDogsPage() {
        return dogsPage;
    }

    public UserMenuController getUserMenuController() {
        return userMenuController;
    }

    public static UserWindowManager getSingletonInstance() {
        if (instance == null) {
            instance = new UserWindowManager();
        }
        return instance;
    }
}