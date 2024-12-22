package view.user.dogadoptionrequestview;

import bean.DogProfileBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CLIDogAdoptionRequestController extends DogAdoptionRequestController{
    private static final Logger logger = LogManager.getLogger(CLIDogAdoptionRequestController.class.getName());

    public void createDogAdoptionRequest(DogProfileBean dogProfileBean) {
        logger.info("Stai mandando una richiesta di adozione al canile {} per {} di razza {} di età {} anni", dogProfileBean.getKennelName(), dogProfileBean.getDogName(), dogProfileBean.getDogBreed(), dogProfileBean.getDogAge());
    }
}
