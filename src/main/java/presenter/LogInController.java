package presenter;

import bean.LoginBean;
import exceptions.IncorrectCredentialsException;
import model.daofactory.DaoFactory;
import model.kennel.Kennel;
import model.login.KennelUser;
import view.kennel.windowmanager.KennelWindowManager;

public class LogInController {
    public void auth(LoginBean loginBean) throws IncorrectCredentialsException {
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();

        KennelUser kennelUser = new KennelUser(username, password);
        if(DaoFactory.getDaoSingletonFactory().createKennelUserDao().check(kennelUser)){
            KennelWindowManager.getSingletonInstance().setKennelId(kennelUser.getKennelId());
            System.out.println(kennelUser.getKennelId());
        }else{
            throw  new IncorrectCredentialsException("Incorrect Credentials");
        }
    }

    public void ultimateRegistration(Kennel kennel, KennelUser kennelUser){
        int kennelId = DaoFactory.getDaoSingletonFactory().createKennelDao().addKennel(kennel);
        kennel.setKennelId(kennelId);
        kennelUser.setKennelId(kennelId);
        DaoFactory.getDaoSingletonFactory().createKennelUserDao().add(kennelUser);
    }
}
