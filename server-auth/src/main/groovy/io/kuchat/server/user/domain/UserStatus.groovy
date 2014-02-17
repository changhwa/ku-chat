package io.kuchat.server.user.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user_status")
class UserStatus {

    @Id
    private String email

    @Column
    private String feel

    @Column
    private String msg

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    String getFeel() {
        return feel
    }

    void setFeel(String feel) {
        this.feel = feel
    }

    String getMsg() {
        return msg
    }

    void setMsg(String msg) {
        this.msg = msg
    }
}
