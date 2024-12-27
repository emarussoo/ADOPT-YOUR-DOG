package model.kennel.dao;

import model.kennel.Kennel;

public abstract class KennelDao {
    public abstract Kennel getKennelById(int kennelId);
    public abstract int addKennel(Kennel kennel);
}
