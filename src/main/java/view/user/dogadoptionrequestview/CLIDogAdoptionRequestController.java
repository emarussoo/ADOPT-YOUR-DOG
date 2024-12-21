package view.user.dogadoptionrequestview;

import bean.DogProfileBean;

public class CLIDogAdoptionRequestController extends DogAdoptionRequestController{
    public void createDogAdoptionRequest(DogProfileBean dogProfileBean) {
        System.out.println("Stai mandando una richiesta di adozione al canile "+ dogProfileBean.getKennelName() +" per "+dogProfileBean.getDogName()+" di razza "+ dogProfileBean.getDogBreed()+" di età "+ dogProfileBean.getDogAge()+ " anni" );
        //TODO
    }
}
