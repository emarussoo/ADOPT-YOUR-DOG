package view.kennel.managedogadoptionrequestview;

import bean.DogAdoptionRequestBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.kennel.windowmanager.KennelWindowManager;
import view.user.dogspageview.CLIDogsPageController;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class CLIManageDarPageController extends ManageDarPageController {
    private static final Logger logger = LogManager.getLogger(CLIManageDarPageController.class.getName());

    public void createDarList(List<DogAdoptionRequestBean> listOfDarsBean) {
        for(DogAdoptionRequestBean dar: listOfDarsBean){
            logger.info("{}, {}, {}, {}, {}", dar.getDarId(), dar.getUserFirstname(), dar.getUserLastname(), dar.getUserEmail(), dar.getUserPhone());
        }
    }

    public int getToRemoveDarIndex() {
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        int index;
        logger.info("Inserisci il numero della richiesta da rifiutare ");
        try{
            index = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return index;
    }

    public DogAdoptionRequestBean getDarInfo(){
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        logger.info("Inserisci l'id della richiesta di adozione");
        int darId;
        try {
            darId = Integer.parseInt(reader.readLine());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return KennelWindowManager.getSingletonInstance().getManageDarController().getDarById(darId);
    }
}
