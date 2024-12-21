package view.user.dogadoptionrequestview;

import bean.DogProfileBean;

public class GUIDogAdoptionRequestController extends DogAdoptionRequestController{
    public void createDogAdoptionRequest(DogProfileBean dogProfileBean) {
        //TODO
        System.out.println("Stai mandando una richiesta di adozione al canile "+ dogProfileBean.getKennelName() +" per "+dogProfileBean.getDogName()+" di razza "+ dogProfileBean.getDogBreed()+" di età "+ dogProfileBean.getDogAge()+ " anni" );
    }
}
