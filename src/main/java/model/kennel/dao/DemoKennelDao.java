package model.kennel.dao;

import model.kennel.Kennel;

import java.util.ArrayList;
import java.util.List;

public class DemoKennelDao extends KennelDao{
    private static List<Kennel> demoListOfKennels= new ArrayList<Kennel>();
    private static DemoKennelDao instance = null;
    private DemoKennelDao(){
        demoListOfKennels.add(new Kennel(34, "Yourbestdogs"));
        demoListOfKennels.add(new Kennel(90, "Tor Vergata's kennel"));
        demoListOfKennels.add(new Kennel(96, "Generic kennel"));
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
}
