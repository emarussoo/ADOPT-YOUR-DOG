package model.login;

import model.kennel.Kennel;

public class KennelUser {
    private String kennelUsername;
    private String kennelPassword;
    private Kennel kennel;

    public KennelUser(String kennelUsername, String kennelPassword, Kennel kennel) {
        this.kennelUsername = kennelUsername;
        this.kennelPassword = kennelPassword;
        this.kennel = kennel;
    }

    public KennelUser(String kennelUsername, String kennelPassword) {
        this.kennelUsername = kennelUsername;
        this.kennelPassword = kennelPassword;
    }

    public String getKennelUsername() {
        return kennelUsername;
    }

    public void setKennelUsername(String kennelUsername) {
        this.kennelUsername = kennelUsername;
    }

    public String getKennelPassword() {
        return kennelPassword;
    }

    public void setKennelPassword(String kennelPassword) {
        this.kennelPassword = kennelPassword;
    }

    public Kennel getKennel() {
        return kennel;
    }

    public void setKennel(Kennel kennel) {
        this.kennel = kennel;
    }
}
