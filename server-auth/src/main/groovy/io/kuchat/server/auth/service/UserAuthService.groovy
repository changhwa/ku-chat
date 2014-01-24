package io.kuchat.server.auth.service

import io.kuchat.server.auth.domain.User
import io.kuchat.server.auth.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserAuthService implements AuthService{

    @Autowired
    UserRepository userRepository

    @Override
    User findUserById(User user) {
        User findUser = userRepository.findOne(user.id)
        findUser
    }
}
