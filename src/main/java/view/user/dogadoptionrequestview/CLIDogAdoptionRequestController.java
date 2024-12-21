package view.user.dogadoptionrequestview;

import bean.DogProfileBean;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CLIDogAdoptionRequestController extends DogAdoptionRequestController{
    private static final Logger logger = Logger.getLogger(CLIDogAdoptionRequestController.class.getName());

    public void createDogAdoptionRequest(DogProfileBean dogProfileBean) {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
        logger.log(Level.INFO, "Stai mandando una richiesta di adozione al canile "+ dogProfileBean.getKennelName() +" per "+dogProfileBean.getDogName()+" di razza "+ dogProfileBean.getDogBreed()+" di età "+ dogProfileBean.getDogAge()+ " anni" );
        //logger.info("Stai mandando una richiesta di adozione al canile "+ dogProfileBean.getKennelName() +" per "+dogProfileBean.getDogName()+" di razza "+ dogProfileBean.getDogBreed()+" di età "+ dogProfileBean.getDogAge()+ " anni" );
    }
}
