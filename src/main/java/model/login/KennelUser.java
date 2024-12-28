package model.login;

public class KennelUser {
    private String kennelUsername;
    private String kennelPassword;
    private int kennelId;

    public KennelUser(String kennelUsername, String kennelPassword, int kennelId) {
        this.kennelUsername = kennelUsername;
        this.kennelPassword = kennelPassword;
        this.kennelId = kennelId;
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

    public int getKennelId() {
        return kennelId;
    }

    public void setKennelId(int kennelId) {
        this.kennelId = kennelId;
    }
}
