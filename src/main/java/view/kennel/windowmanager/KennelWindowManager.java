package view.kennel.windowmanager;

import view.user.windowmanager.UserWindowManager;

public class KennelWindowManager {
   // private KennelMenuController kennelMenuController = new KennelMenuController();
    private static KennelWindowManager instance;
    private KennelWindowManager() {}



   /* public void show(){
        kennelMenuController.show();
    }*/
    public static KennelWindowManager getSingletonInstance() {
        if (instance == null) {
            instance = new KennelWindowManager(); // Creazione solo se necessario
        }
        return instance; // Ritorna sempre l'istanza unica
    }
}
