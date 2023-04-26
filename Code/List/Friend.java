public class Friend {
    private String username;
    private boolean status = false; // false - offline; true online

    public Friend(String username, boolean status) {
        this.username = username;
        this.status = status;
    }

    public Friend(String username) {
        this(username, false);
    }

    public void setStatus(boolean online) {
        this.status = online;
    }

    @Override
    public String toString() {
        String s = this.status ?  "Online" : "Offline";
        return username + " " + s;
    }
}
