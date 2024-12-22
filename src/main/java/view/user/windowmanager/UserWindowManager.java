package view.user.windowmanager;

import bean.BreedBean;
import bean.DogAdoptionRequestBean;
import bean.DogProfileBean;
import bean.TestBean;
import presenter.AdoptDogController;
import view.user.dogadoptionrequestview.DogAdoptionRequestController;
import view.user.dogspageview.DogsPageController;
import view.user.factory.GraphicalFactory;
import view.user.testview.TestViewController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class UserWindowManager {
    private final TestViewController testView = GraphicalFactory.getGraphicalSingletonFactory().createTestViewController();
    private final DogsPageController dogsPage = GraphicalFactory.getGraphicalSingletonFactory().createDogsPageController();
    private final DogAdoptionRequestController dogAdoptionRequestPage = GraphicalFactory.getGraphicalSingletonFactory().createDogAdoptionRequestController();
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
        testView.createTest();
    }

    public void submitTest(){
        try {
            List<String> listOfAnswers = testView.getTestAnswers();
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
        testView.createTestResult(breedBean);
    }



    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    public void submitSearch(List<DogProfileBean> listOfDogs){
        String insertedBreed = dogsPage.getInsertedBreed();
        List<DogProfileBean> filteredDogs = presenter.getDogsByBreed(listOfDogs, insertedBreed);
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
        List<String> dogAdoptionRequestInfo = dogAdoptionRequestPage.getUserInfo();
        String userNameBean = dogAdoptionRequestInfo.get(0);
        String userSurnameBean = dogAdoptionRequestInfo.get(1);
        String userEmailBean = dogAdoptionRequestInfo.get(2);
        String userPhoneBean = dogAdoptionRequestInfo.get(3);
        String dogIdBean = dogProfileBean.getDogId();
        String kennelIdBean = dogProfileBean.getKennelId();
        DogAdoptionRequestBean dogAdoptionRequestBean= new DogAdoptionRequestBean(userNameBean, userSurnameBean, userEmailBean, userPhoneBean, dogIdBean, kennelIdBean);
        presenter.sendDogAdoptionRequest(dogAdoptionRequestBean);
        dogAdoptionRequestPage.createMessage("Richiesta inviata correttamente");
    }






    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    public TestViewController getTestView() {
        return testView;
    }

    public DogsPageController getDogsPage() {
        return dogsPage;
    }

    public UserMenuController getStarterWindow() {
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