package view.user.windowmanager;

import bean.*;
import presenter.AdoptDogController;
import view.user.dogadoptionrequestview.DogAdoptionRequestPageController;
import view.user.dogspageview.DogsPageController;
import view.factory.GraphicalFactory;
import view.user.testview.TestPageController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class UserWindowManager {
    private final TestPageController testPage = GraphicalFactory.getGraphicalSingletonFactory().createTestViewController();
    private final DogsPageController dogsPage = GraphicalFactory.getGraphicalSingletonFactory().createDogsPageController();
    private final DogAdoptionRequestPageController dogAdoptionRequestPage = GraphicalFactory.getGraphicalSingletonFactory().createDogAdoptionRequestController();
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

    public void submitTest(){
        try {
            List<String> listOfAnswers = testPage.getTestAnswers();
            TestBean testAnswers = new TestBean(listOfAnswers);
            BreedBean resultBreed = presenter.processTestAnswers(testAnswers);
            showTestResult(resultBreed);

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void showTestResult(BreedBean breedBean){
        testPage.createTestResult(breedBean);
    }



    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    public void submitSearch(List<DogProfileBean> listOfDogs){
        String insertedBreed = dogsPage.getInsertedBreed();
        DogBreedSearchBean dogBreedSearchBean = new DogBreedSearchBean(insertedBreed);
        List<DogProfileBean> filteredDogs = presenter.getDogsByBreed(listOfDogs, dogBreedSearchBean);
        showListOfDogs(filteredDogs);
    }

    public List<DogProfileBean> getAllDogs(){
        return presenter.getAllDogs();
    }

    public void showAllDogs(){
        List<DogProfileBean> allDogs = getAllDogs();
        showListOfDogs(allDogs);
        //it will call presenter.getDogsByBreed with empty params
    }

    public void showListOfDogs(List<DogProfileBean> listOfDogs){
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
        List<String> dogAdoptionRequestUserInfo = dogAdoptionRequestPage.getUserInfo();
        String userNameBean = dogAdoptionRequestUserInfo.get(0);
        String userSurnameBean = dogAdoptionRequestUserInfo.get(1);
        String userEmailBean = dogAdoptionRequestUserInfo.get(2);
        String userPhoneBean = dogAdoptionRequestUserInfo.get(3);
        String dogIdBean = dogProfileBean.getDogId();
        String kennelIdBean = dogProfileBean.getKennelId();
        DogAdoptionRequestBean dogAdoptionRequestBean= new DogAdoptionRequestBean(userNameBean, userSurnameBean, userEmailBean, userPhoneBean, dogIdBean, kennelIdBean);
        presenter.sendDogAdoptionRequest(dogAdoptionRequestBean);
        dogAdoptionRequestPage.createMessage("Richiesta inviata correttamente");
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
            instance = new UserWindowManager(); // Creazione solo se necessario
        }
        return instance; // Ritorna sempre l'istanza unica
    }
}