package presenter;

import bean.DogAdoptionRequestBean;
import model.daofactory.DaoFactory;
import model.dogadoptionrequest.DogAdoptionRequest;

import java.util.ArrayList;
import java.util.List;

public class ManageDarController {
    public ManageDarController() {
        //costrutore
    }

    public DogAdoptionRequestBean getDarById(int darId){
        DogAdoptionRequest dogAdoptionRequest = DaoFactory.getDaoSingletonFactory().createDogAdoptionRequestDao().getDarById(darId);
        String darIdBean = Integer.toString(dogAdoptionRequest.getDarId());
        String userFirstNameBean = dogAdoptionRequest.getUserFirstname();
        String userLastNameBean = dogAdoptionRequest.getUserLastname();
        String userEmailBean = dogAdoptionRequest.getUserEmail();
        String userPhoneBean = dogAdoptionRequest.getUserPhone();
        String dogIdBean = Integer.toString(dogAdoptionRequest.getDogId());
        String kennelIdBean = Integer.toString(dogAdoptionRequest.getKennelId());
        return new DogAdoptionRequestBean(darIdBean, userFirstNameBean, userLastNameBean, userEmailBean, userPhoneBean, dogIdBean, kennelIdBean);
    }

    public List<DogAdoptionRequestBean> getDarsWithKennelId(int kennelId){
        List<DogAdoptionRequest> listOfDar;
        List<DogAdoptionRequestBean> filteredDarList = new ArrayList<>();
        listOfDar = DaoFactory.getDaoSingletonFactory().createDogAdoptionRequestDao().getAllDogAdoptionRequest();
        for(DogAdoptionRequest dar : listOfDar){
            if(dar.getKennelId() == kennelId){
                String darIdBean = Integer.toString(dar.getDarId());
                String userFirstNameBean = dar.getUserFirstname();
                String userLastNameBean = dar.getUserLastname();
                String userEmailBean = dar.getUserEmail();
                String userPhoneBean = dar.getUserPhone();
                String dogIdBean = Integer.toString(dar.getDogId());
                String kennelIdBean = Integer.toString(dar.getKennelId());
                filteredDarList.add(new DogAdoptionRequestBean(darIdBean, userFirstNameBean, userLastNameBean, userEmailBean, userPhoneBean, dogIdBean, kennelIdBean));
            }
        }

        return filteredDarList;
    }

    public void removeDar(DogAdoptionRequestBean dogAdoptionRequestBean){
        int darId = Integer.parseInt(dogAdoptionRequestBean.getDarIdBean());
        DaoFactory.getDaoSingletonFactory().createDogAdoptionRequestDao().removeDarById(darId);
    }

    public void removeAllDarByDogId(int dogId){
        DaoFactory.getDaoSingletonFactory().createDogAdoptionRequestDao().removeAllDarByDogId(dogId);

    }

    public void sendEmail(String email){
        //send email to user email
    }
}
