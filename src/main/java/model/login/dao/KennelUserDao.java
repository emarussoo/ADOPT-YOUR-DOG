package model.login.dao;

import model.login.KennelUser;

public abstract class KennelUserDao {
    //this will be used to check if exists a user with inserted credentials. If it does, it sets corresponding kennel id
    public abstract boolean check(KennelUser user);
    //used to add a kennel user to persistence layer
    public abstract void add(KennelUser user);

}
