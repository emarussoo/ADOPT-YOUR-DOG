package controller;

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
            Kennel kennel = DaoFactory.getDaoSingletonFactory().createKennelDao().loadKennelDataById(kennelUser.getKennel().getKennelId());
            KennelWindowManager.getSingletonInstance().setKennel(kennel);
        }else{
            throw  new IncorrectCredentialsException("Incorrect Credentials");
        }
    }

    public void ultimateRegistration(Kennel kennel, KennelUser kennelUser){
        int kennelId = DaoFactory.getDaoSingletonFactory().createKennelDao().addKennel(kennel);
        kennel.setKennelId(kennelId);
        kennelUser.setKennel(kennel);
        DaoFactory.getDaoSingletonFactory().createKennelUserDao().add(kennelUser);
    }
}
