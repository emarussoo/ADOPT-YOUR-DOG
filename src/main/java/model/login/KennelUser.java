package model.login;

public class KennelUser {
    private String username;
    private String password;
    private int kennelId;

    public KennelUser(String username, String password, int kennelId) {
        this.username = username;
        this.password = password;
        this.kennelId = kennelId;
    }

    public KennelUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getKennelId() {
        return kennelId;
    }

    public void setKennelId(int kennelId) {
        this.kennelId = kennelId;
    }
}
