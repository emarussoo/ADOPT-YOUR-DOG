package presenter;

import bean.LoginBean;
import model.daofactory.DaoFactory;
import model.login.KennelUser;
import model.login.dao.KennelUserDao;

public class LogInController {
    public boolean auth(LoginBean loginBean){
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();

        KennelUser kennelUser = new KennelUser(username, password);
        DaoFactory.getDaoSingletonFactory().createKennelUserDao().check(kennelUser);
        return true;
    }
}
