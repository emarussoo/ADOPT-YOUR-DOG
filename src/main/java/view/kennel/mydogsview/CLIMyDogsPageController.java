package view.kennel.mydogsview;

import bean.DogProfileBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.user.dogspageview.CLIDogsPageController;

import java.util.List;

public class CLIMyDogsPageController extends MyDogsPageController {
    private static final Logger logger = LogManager.getLogger(CLIDogsPageController.class.getName());

    @Override
    public void createMyDogsList(List<DogProfileBean> listOfDogsBean) {
        for(DogProfileBean dog: listOfDogsBean){
            logger.info("{}, {}, {}, {}", dog.getDogId(), dog.getDogName(), dog.getDogAge(), dog.getDogBreed());
        }

    }
}