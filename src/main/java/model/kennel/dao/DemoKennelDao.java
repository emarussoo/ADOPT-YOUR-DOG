package model.kennel.dao;

import model.kennel.Kennel;

import java.util.ArrayList;
import java.util.List;

public class DemoKennelDao extends KennelDao{
    private static List<Kennel> demoListOfKennels= new ArrayList<Kennel>();
    private static DemoKennelDao instance = null;

    private int counter = 3;

    protected DemoKennelDao(){
        demoListOfKennels.add(new Kennel(1, "John Doe Kennel"));
        demoListOfKennels.add(new Kennel(2, "Francesco totti kennel"));
    }

    public static KennelDao getSingletonInstance() {
        if(instance == null){
            instance = new DemoKennelDao();
        }
        return instance;
    }
    public Kennel getKennelById(int kennelId) {
        for(Kennel kennel: demoListOfKennels){
            if(kennel.getKennelId() == kennelId){
                return kennel;
            }
        }
        return null;
    }

    public int addKennel(Kennel kennel) {
        demoListOfKennels.add(kennel);
        return counter++;
    }
}
