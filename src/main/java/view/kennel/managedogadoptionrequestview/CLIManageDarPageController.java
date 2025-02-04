package view.kennel.managedogadoptionrequestview;
import bean.DogAdoptionRequestBean;
import controller.ManageDarController;
import exceptions.GenericSystemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.kennel.windowmanager.KennelWindowManager;
import java.io.BufferedReader;
import java.util.List;

public class CLIManageDarPageController extends ManageDarPageController {
    private static final Logger logger = LogManager.getLogger(CLIManageDarPageController.class.getName());

    public void createDarList(List<DogAdoptionRequestBean> listOfDarsBean) {
        for(DogAdoptionRequestBean dar: listOfDarsBean){
            logger.info("{}, {}, {}, {}, {}", dar.getDarIdBean(), dar.getUserFirstnameBean(), dar.getUserLastnameBean(), dar.getUserEmailBean(), dar.getUserPhoneBean());
        }
    }

    public DogAdoptionRequestBean getDarInfo() throws GenericSystemException {
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        logger.info("Inserisci l'id della richiesta di adozione");
        int darId;
        try {
            darId = Integer.parseInt(reader.readLine());

        } catch (Exception e) {
            throw new GenericSystemException(e.getMessage());
        }
        ManageDarController manageDarController = new ManageDarController();
        return manageDarController.getDarById(darId);
    }
}
