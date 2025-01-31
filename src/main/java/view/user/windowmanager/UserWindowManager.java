package view.user.windowmanager;

import bean.*;
import exceptions.*;
import presenter.AdoptDogController;
import view.user.dogadoptionrequestview.DogAdoptionRequestPageController;
import view.user.dogspageview.DogsPageController;
import view.factory.GraphicalFactory;
import view.user.testview.TestPageController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class UserWindowManager {
    private final TestPageController testPage = GraphicalFactory.getGraphicalSingletonFactory().createTestPageController();
    private final DogsPageController dogsPage = GraphicalFactory.getGraphicalSingletonFactory().createDogsPageController();
    private final DogAdoptionRequestPageController dogAdoptionRequestPage = GraphicalFactory.getGraphicalSingletonFactory().createDogAdoptionRequestPageController();
    private final UserMenuController userMenuController = GraphicalFactory.getGraphicalSingletonFactory().createUserMenuController();
    private final AdoptDogController presenter = new AdoptDogController();

    private static UserWindowManager instance = null;

    protected UserWindowManager() {
        // Inizializzazione se necessaria
    }

    public void show(){
        userMenuController.show();
    }

    public void showTest(){
        testPage.createTest();
    }

    public void submitTest() throws GenericSystemException, URISyntaxException, IOException, InterruptedException {
        try {
            List<String> listOfAnswers = testPage.getTestAnswers();
            TestBean testAnswers = new TestBean(listOfAnswers);
            BreedBean resultBreed = presenter.processTestAnswers(testAnswers);
            showTestResult(resultBreed);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (DogNotFoundException | InvalidBreedTestInput e){
            UserWindowManager.getSingletonInstance().getTestView().createMessage(e.getMessage());

        }
    }

    private void showTestResult(BreedBean breedBean){
        testPage.createTestResult(breedBean);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    public void submitSearch(){
        String insertedBreed = dogsPage.getInsertedBreed();
        DogBreedSearchBean dogBreedSearchBean = new DogBreedSearchBean(insertedBreed);
        List<DogProfileBean> filteredDogs = presenter.getDogsByBreed(dogBreedSearchBean);
        showListOfDogs(filteredDogs);
    }

    public List<DogProfileBean> getAllDogs(){
        return presenter.getAllDogs();
    }

    public void showAllDogs(){
        List<DogProfileBean> allDogs = getAllDogs();
        showListOfDogs(allDogs);
    }

    private void showListOfDogs(List<DogProfileBean> listOfDogs){
        dogsPage.createListOfDogs(listOfDogs);
    }

    public DogProfileBean  showDogAdoptionRequestForm(){
        DogProfileBean dogProfileBean = dogsPage.getDogInfo();
        dogAdoptionRequestPage.createDogAdoptionRequest(dogProfileBean);
        return dogProfileBean;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

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
            presenter.sendDogAdoptionRequest(dogAdoptionRequestBean);
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

    public AdoptDogController getPresenter() {
        return presenter;
    }

    public static UserWindowManager getSingletonInstance() {
        if (instance == null) {
            instance = new UserWindowManager();
        }
        return instance;
    }
}