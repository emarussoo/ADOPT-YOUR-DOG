package model.kennel;

public class Kennel {
    private int kennelId;
    private String kennelName;

    public Kennel(int kennelId, String kennelName) {
        this.kennelId = kennelId;
        this.kennelName = kennelName;
    }

    public Kennel(String kennelName) {
        this.kennelName = kennelName;
    }

    public Kennel(){}

    public int getKennelId() {
        return kennelId;
    }

    public void setKennelId(int kennelId) {
        this.kennelId = kennelId;
    }

    public String getKennelName() {
        return kennelName;
    }

    public void setKennelName(String kennelName) {
        this.kennelName = kennelName;
    }
}
