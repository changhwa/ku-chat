package io.kuchat.server.auth.service

import io.kuchat.server.auth.domain.User
import io.kuchat.server.auth.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserAuthService implements AuthService{

    @Autowired
    UserRepository userRepository

    @Transactional
    @Override
    User login(User user) {

        User findUser = userRepository.findByEmailAndPasswd(user.email, user.passwd)

        if(findUser != null){
            //login_cnt 를 0으로 업데이트
            findUser.loginCnt = 0
            user.loginCnt = 0
        } else {
            //해당 email에 login_cnt를 1로 업데이트
            findUser = userRepository.findByEmail(user.email)
            if(findUser != null)
                user.loginCnt = ++findUser.loginCnt
        }

        findUser
    }
}
