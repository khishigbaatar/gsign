package biz.gsign.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DatabaseUser {
    private long id;
    private String username;
    private String fullname;
    private String encryptedPassword;
    private String companyName;

    public DatabaseUser(
            long id,
            String username,
            String fullName,
            String companyName
    ) {
        this.id = id;
        this.username = username;
        this.fullname = fullName;
        this.companyName = companyName;
    }

    public DatabaseUser(
            long id,
            String username,
            String fullname,
            String companyName,
            String encryptedPassword
    ) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.companyName = companyName;
        this.encryptedPassword = encryptedPassword;
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

    @JsonIgnore
    public String getEncodedPassword() {
        return encryptedPassword;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DatabaseUser that = (DatabaseUser) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (fullname != null ? !fullname.equals(that.fullname) : that.fullname != null) return false;
        if (encryptedPassword != null ? !encryptedPassword.equals(that.encryptedPassword) : that.encryptedPassword != null)
            return false;
        return companyName != null ? companyName.equals(that.companyName) : that.companyName == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (encryptedPassword != null ? encryptedPassword.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DatabaseUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", encryptedPassword='" + encryptedPassword + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
