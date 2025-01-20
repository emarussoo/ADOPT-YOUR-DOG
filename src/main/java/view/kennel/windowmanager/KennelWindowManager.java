package view.kennel.windowmanager;

import bean.DogAdoptionRequestBean;
import bean.DogProfileBean;
import exceptions.EmptyFieldsException;
import exceptions.InvalidFieldException;
import model.daofactory.DaoFactory;
import model.dog.Dog;
import model.dogadoptionrequest.DogAdoptionRequest;
import model.kennel.Kennel;
import presenter.ManageDarController;
import presenter.ManageDogsController;
import view.factory.GraphicalFactory;
import view.kennel.addadogview.AddDogPageController;
import view.kennel.managedogadoptionrequestview.ManageDarPageController;
import view.kennel.mydogsview.MyDogsPageController;

import java.util.ArrayList;
import java.util.List;

public class KennelWindowManager {
    Kennel loggedKennel;
    private AddDogPageController addDogPage = GraphicalFactory.getGraphicalSingletonFactory().createAddDogPageController();
    private ManageDarPageController manageDarPage = GraphicalFactory.getGraphicalSingletonFactory().createManageDarPageController();
    private MyDogsPageController myDogsPage = GraphicalFactory.getGraphicalSingletonFactory().createMyDogsPageController();
    private KennelMenuController kennelMenuController = GraphicalFactory.getGraphicalSingletonFactory().createKennelMenuController();
    private ManageDarController manageDarController = new ManageDarController();
    private ManageDogsController manageDogsController = new ManageDogsController();
    private static KennelWindowManager instance;

    protected KennelWindowManager() {}

    public void show(){
        kennelMenuController.show();
    }

    public void showAddDog(){
        addDogPage.createAddForm();
    }

    public void showMyDars(){

        List<DogAdoptionRequestBean> listOfAllDarBean = new ArrayList<>();
        for(DogAdoptionRequest dar : loggedKennel.getKennelRequests()){
            String darIdBean = Integer.toString(dar.getDarId());
            String userFirstNameBean = dar.getUserFirstname();
            String userLastNameBean = dar.getUserLastname();
            String userEmailBean = dar.getUserEmail();
            String userPhoneBean = dar.getUserPhone();
            String dogIdBean = Integer.toString(dar.getDog().getDogId());
            String kennelIdBean = Integer.toString(dar.getKennel().getKennelId());

            listOfAllDarBean.add(new DogAdoptionRequestBean(darIdBean, userFirstNameBean, userLastNameBean, userEmailBean, userPhoneBean, dogIdBean, kennelIdBean));
        }
        manageDarPage.createDarList(listOfAllDarBean);
    }

    public void showMyDogs(){
        List<DogProfileBean> listOfMyDogs = new ArrayList<>();
        for(Dog dog: loggedKennel.getKennelDogs()){
            String dogIdBean = Integer.toString(dog.getDogId());
            String dogNameBean = dog.getDogName();
            String dogAgeBean = Integer.toString(dog.getDogAge());
            String dogBreedBean = dog.getDogBreed();
            String kennelIdBean = Integer.toString(dog.getKennel().getKennelId());
            listOfMyDogs.add(new DogProfileBean(dogIdBean, dogNameBean, dogAgeBean, dogBreedBean, kennelIdBean));
        }
        myDogsPage.createMyDogsList(listOfMyDogs);
    }

    public void acceptDar(){
        DogAdoptionRequestBean toAcceptDar = manageDarPage.getDarInfo();
        manageDarController.removeAllDarByDogId(Integer.parseInt(toAcceptDar.getDogIdBean()));
        manageDogsController.removeDogByDar(toAcceptDar);
        loggedKennel = DaoFactory.getDaoSingletonFactory().createKennelDao().loadKennelDataById(loggedKennel.getKennelId());
        showMyDars();
        //notifica utente
    }

    public void rejectDar(){
        DogAdoptionRequestBean toRemoveDar = manageDarPage.getDarInfo();
        String email = toRemoveDar.getUserEmailBean();
        manageDarController.removeDar(toRemoveDar);
        manageDarController.sendEmail(email);
        //notifica utente
        loggedKennel = DaoFactory.getDaoSingletonFactory().createKennelDao().loadKennelDataById(loggedKennel.getKennelId());
        showMyDars();
    }

    public void submitAdd(){
        List<String> dogInfo;
        try {
            dogInfo = addDogPage.getDogInfo();
            String dogNameBean = dogInfo.get(0);
            String dogAgeBean = dogInfo.get(1);
            String dogBreedBean = dogInfo.get(2);
            String kennelIdBean = String.valueOf(loggedKennel.getKennelId());
            DogProfileBean dogProfileBean = new DogProfileBean(dogNameBean, dogAgeBean, dogBreedBean, kennelIdBean);
            manageDogsController.addDog(dogProfileBean);
            loggedKennel = DaoFactory.getDaoSingletonFactory().createKennelDao().loadKennelDataById(loggedKennel.getKennelId());
            addDogPage.createMessage("Dog added");
        }catch(EmptyFieldsException | InvalidFieldException e) {
            addDogPage.createMessage(e.getMessage());
        }

    }
    public static KennelWindowManager getSingletonInstance() {
        if (instance == null) {
            instance = new KennelWindowManager(); // Creazione solo se necessario
        }
        return instance; // Ritorna sempre l'istanza unica
    }

    public KennelMenuController getKennelMenuController() {
        return kennelMenuController;
    }

    public ManageDogsController getManageDogsController() {
        return manageDogsController;
    }

    public ManageDarController getManageDarController() {
        return manageDarController;
    }

    public int getKennelId() {
        return loggedKennel.getKennelId();
    }

    public String getKennelName(){
        return loggedKennel.getKennelName();
    }

    public void setKennel(Kennel kennel) {
        this.loggedKennel = kennel;
    }

}
