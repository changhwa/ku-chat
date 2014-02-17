package io.kuchat.server.user.service

import io.kuchat.server.auth.domain.User
import io.kuchat.server.config.AppConfig
import io.kuchat.server.user.domain.UserStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = AppConfig.class)
class UserServiceTest extends Specification{

    @Autowired
    private UserService userService

    def "회원정보를 가져온다"(){

        given : "아이디가 test99@test.com 라 가정"
        String email = "test99@test.com"

        when: "정보를 가져온다"
        User user = userService.findUserInfo(email)

        then: "결과는"
        UserStatus status = user.getUserStatus()
        status.feel == "smile"

    }
}
