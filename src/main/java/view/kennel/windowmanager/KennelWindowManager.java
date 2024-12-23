package view.kennel.windowmanager;

import bean.DogAdoptionRequestBean;
import bean.DogProfileBean;
import model.daofactory.DaoFactory;
import model.dog.Dog;
import presenter.ManageDarController;
import presenter.ManageDogsController;
import view.factory.GraphicalFactory;
import view.kennel.addadogview.AddDogPageController;
import view.kennel.managedogadoptionrequestview.ManageDarPageController;
import view.kennel.mydogsview.MyDogsPageController;

import java.util.ArrayList;
import java.util.List;

public class KennelWindowManager {
    private int kennelId;
    private AddDogPageController addDogPage = GraphicalFactory.getGraphicalSingletonFactory().createAddDogPageController();
    private ManageDarPageController manageDarPage = GraphicalFactory.getGraphicalSingletonFactory().createManageDarPageController();
    private MyDogsPageController myDogsPage = GraphicalFactory.getGraphicalSingletonFactory().createMyDogsPageController();
    private KennelMenuController kennelMenuController = GraphicalFactory.getGraphicalSingletonFactory().createKennelMenuController();
    private ManageDarController manageDarController = new ManageDarController();
    private ManageDogsController manageDogsController = new ManageDogsController();
    private static KennelWindowManager instance;
    private KennelWindowManager() {}

    public void show(){
        kennelMenuController.show();
    }

    public void showAddDog(){
        System.out.println("showing add dog");
    }

    public void showMyDars(){
        List<DogAdoptionRequestBean> listOfAllDarBean = manageDarController.getDarsWithKennelId(96);
        manageDarPage.createDarList(listOfAllDarBean);
    }

    public void showMyDogs(){
        List<DogProfileBean> myDogs = manageDogsController.getDogsWithKennelId(96);
        myDogsPage.createMyDogsList(myDogs);
        //System.out.println("showing my dogs");
    }

    public void acceptDar(){
        DogAdoptionRequestBean toAcceptDar = manageDarPage.getDarInfo();
        manageDarController.removeDar(toAcceptDar);
        manageDogsController.removeDogByDar(toAcceptDar);
        showMyDars();
        //notifica utente
    }

    public void rejectDar(){
        DogAdoptionRequestBean toRemoveDar = manageDarPage.getDarInfo();
        manageDarController.removeDar(toRemoveDar);
        //notifica utente
        showMyDars();
    }



   /* public void show(){
        kennelMenuController.show();
    }*/
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
        return kennelId;
    }

    public void setKennelId(int kennelId) {
        this.kennelId = kennelId;
    }
}
