package model.login.dao;

import model.login.KennelUser;

public abstract class KennelUserDao {
    public abstract boolean check(KennelUser user);

    public abstract void add(KennelUser user);

}
