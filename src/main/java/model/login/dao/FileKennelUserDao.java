package model.login.dao;

import model.login.KennelUser;

public class FileKennelUserDao extends KennelUserDao {
    public boolean check(KennelUser user) {
        return true;
    }

    public void add(KennelUser user) {
        //add in file csv
    }
}
