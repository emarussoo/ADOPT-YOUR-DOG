package presenter;

import bean.LoginBean;
import model.daofactory.DaoFactory;
import model.login.KennelUser;
import model.login.dao.KennelUserDao;
import view.kennel.windowmanager.KennelWindowManager;

public class LogInController {
    public boolean auth(LoginBean loginBean){
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();

        KennelUser kennelUser = new KennelUser(username, password);
        if(DaoFactory.getDaoSingletonFactory().createKennelUserDao().check(kennelUser)){
            KennelWindowManager.getSingletonInstance().setKennelId(kennelUser.getKennelId());
            System.out.println(kennelUser.getKennelId());
            return true;
        }
        return false;
    }
}
