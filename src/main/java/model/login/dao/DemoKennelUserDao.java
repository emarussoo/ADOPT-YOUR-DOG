package model.login.dao;

import model.login.KennelUser;

import java.util.ArrayList;
import java.util.List;

public class DemoKennelUserDao extends KennelUserDao {
    private static DemoKennelUserDao instance = null;
    private List<KennelUser> kennelUsers = new ArrayList<KennelUser>();
    private DemoKennelUserDao() {
        kennelUsers.add(new KennelUser("John", "Doe", 1));
        kennelUsers.add(new KennelUser("canile", "prova", 2));
    }
    public static DemoKennelUserDao getInstance() {
        if (instance == null) {
            instance = new DemoKennelUserDao();
        }
        return instance;
    }
    public boolean check(KennelUser user) {
        //vedi se esiste e imposta il kennel id dell'entità passata
        return true;
    }
}
