package model.login.dao;

import model.login.KennelUser;

import java.util.ArrayList;
import java.util.List;

public class DemoKennelUserDao extends KennelUserDao {
    private static DemoKennelUserDao instance = null;
    private List<KennelUser> kennelUsers = new ArrayList<KennelUser>();

    protected DemoKennelUserDao() {
    }
    public static DemoKennelUserDao getInstance() {
        if (instance == null) {
            instance = new DemoKennelUserDao();
        }
        return instance;
    }
    public boolean check(KennelUser user) {
        for (KennelUser kennelUser : kennelUsers) {
            if (kennelUser.getKennelUsername().equals(user.getKennelUsername()) && kennelUser.getKennelPassword().equals(user.getKennelPassword())) {
                user.setKennel(kennelUser.getKennel());
                return true;
            }
        }
        //vedi se esiste e imposta il kennel id dell'entità passata
        return false;
    }

    public void add(KennelUser user) {
        kennelUsers.add(user);
    }

}
