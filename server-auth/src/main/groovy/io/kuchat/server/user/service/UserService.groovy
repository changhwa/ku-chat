package io.kuchat.server.user.service

import io.kuchat.server.auth.domain.User
import io.kuchat.server.auth.repository.UserRepository
import io.kuchat.server.user.domain.UserStatus
import io.kuchat.server.user.repository.UserStatusRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserService {

    @Autowired
    UserRepository userRepository

    @Autowired
    UserStatusRepository userStatusRepository

    def findUserInfo(String email){
        User user = userRepository.findOne(email)
        user
    }

    @Transactional
    def updateUserStatus(UserStatus status){
        UserStatus userStatus = userStatusRepository.findOne(status.email)
        if (userStatus != null){
            userStatus.feel = status.feel
        }
        User user = new User()
        user.userStatus = userStatus;
        user.email = userStatus.email
        user
    }

}
