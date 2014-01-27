package io.kuchat.server.auth.service

import io.kuchat.server.auth.domain.User
import io.kuchat.server.config.AppConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

@ContextConfiguration(classes = AppConfig.class)
class UserAuthServiceTest extends Specification{

    @Autowired
    AuthService userAuthService

    def "로그인을 시도해서 성공한다"(){

        given : "email은 test99@test.com , passwd : 1234 라고 가정"
        User user = new User()
        user.email = "test99@test.com"
        user.passwd = "1234"

        when : "로그인을 시도할때"
        User resultUser = userAuthService.login(user)

        then : ""
        resultUser.email == user.email
    }

    def "로그인을 시도해서 비밀번호가 틀린다"(){

        given : "email은 test99@test.com , passwd : 1234 라고 가정"
        User user = new User()
        user.email = "test99@test.com"
        user.passwd = "4321"

        when : "로그인을 시도할때"
        User resultUser = userAuthService.login(user)

        then : "로그인 시도 횟수가 1로 증가한다"
        resultUser.email == user.email
        resultUser.loginCnt == 1
    }

    def "로그인을 시도해서 이메일 주소가 없는 경우"(){

        given: "존재하지 않는 이메일로 로그인한다 가정"
        User user = new User()
        user.email = "nonmail@nonmail.com"
        user.passwd = "1234"

        when: "로그인을 시도할 때"
        User resultUser = userAuthService.login(user)

        then: ""
        resultUser == null
    }

}
