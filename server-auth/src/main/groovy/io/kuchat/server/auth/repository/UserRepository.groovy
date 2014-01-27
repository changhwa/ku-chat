package io.kuchat.server.auth.repository

import io.kuchat.server.auth.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

public interface UserRepository extends JpaRepository<User, Integer>{

    /**
     * 사용자 정보를 조회함
     * @param email 이메일주소
     * @param passwd 암호
     * @return the User Domain
     */
    User findByEmailAndPasswd(String email, String passwd)

    /**
     * 사용자 정보를 메일을 기준으로 조회함
     * @param email 이메일주소
     * @return
     */
    User findByEmail(String email)

}