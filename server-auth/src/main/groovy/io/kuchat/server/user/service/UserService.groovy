package io.kuchat.server.user.service

import io.kuchat.server.auth.domain.User
import io.kuchat.server.auth.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserService {

    @Autowired
    UserRepository userRepository

    def findUserInfo(String email){
        User user = userRepository.findOne(email)
        user
    }

}
