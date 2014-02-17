package io.kuchat.server.auth.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    private String email;
    private String name;
    private String passwd;
    private int loginCnt;


    @javax.persistence.Column(name = "email")
    @Id
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @javax.persistence.Column(name = "name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @javax.persistence.Column(name = "passwd")
    @Basic
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @javax.persistence.Column(name = "login_cnt")
    @Basic
    public int getLoginCnt() {
        return loginCnt;
    }

    public void setLoginCnt(int loginCnt) {
        this.loginCnt = loginCnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (loginCnt != user.loginCnt) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (passwd != null ? !passwd.equals(user.passwd) : user.passwd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (passwd != null ? passwd.hashCode() : 0);
        result = 31 * result + loginCnt;
        return result;
    }
}
