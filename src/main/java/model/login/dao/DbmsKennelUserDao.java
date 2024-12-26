package model.login.dao;

import model.login.KennelUser;

public class DbmsKennelUserDao extends KennelUserDao {
    public boolean check(KennelUser user) {
        return true;
    }
}
