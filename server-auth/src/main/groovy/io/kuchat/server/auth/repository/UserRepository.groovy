package io.kuchat.server.auth.repository

import io.kuchat.server.auth.domain.User
import org.springframework.data.jpa.repository.JpaRepository

public interface UserRepository extends JpaRepository<User, Integer>{

}