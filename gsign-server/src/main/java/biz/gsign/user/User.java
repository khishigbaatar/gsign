package biz.gsign.user;

import java.io.Serializable;

public class User implements Serializable {
    private long id;
    private String username;
    private String fullname;
    private String companyName;

    public User() {
    }

    public User(long id, String username, String fullName, String companyName) {
        this.id = id;
        this.username = username;
        this.fullname = fullName;
        this.companyName = companyName;
    }

    public User(DatabaseUser databaseUser) {
        this.id = databaseUser.getId();
        this.username = databaseUser.getUsername();
        this.fullname = databaseUser.getFullname();
        this.companyName = databaseUser.getCompanyName();
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (fullname != null ? !fullname.equals(user.fullname) : user.fullname != null) return false;
        return companyName != null ? companyName.equals(user.companyName) : user.companyName == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
