package io.kuchat.server.user.repository

import io.kuchat.server.user.domain.UserStatus
import org.springframework.data.jpa.repository.JpaRepository

interface UserStatusRepository extends JpaRepository <UserStatus, String>{
}
