package io.kuchat.server.user.service

import io.kuchat.server.auth.domain.User
import io.kuchat.server.config.AppConfig
import io.kuchat.server.helper.TestHelper
import io.kuchat.server.helper.UserTestHelper
import io.kuchat.server.user.domain.UserStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Shared
import spock.lang.Specification

@ContextConfiguration(classes = AppConfig.class)
class UserServiceTest extends Specification{

    @Autowired
    private UserService userService

    def spec(){
        TestHelper testHelper = new UserTestHelper()
        testHelper.helper()
    }

    def setupSpec(){
        spec()
    }

    def cleanupSpec(){
        spec()
    }

    def "회원정보를 가져온다"(){

        given : "아이디가 test2@b.com 라 가정"
        String email = "test2@b.com"

        when: "정보를 가져온다"
        User user = userService.findUserInfo(email)

        then: "결과는"
        UserStatus status = user.getUserStatus()
        status.feel == "smile"

    }

    def "기분을 변경한다"(){

        given : "test2의 기분을 sad로 변경"
        UserStatus status = new UserStatus()
        status.email = "test2@b.com"
        status.feel = "sad"

        when: "변경을 시도"
        User user = userService.updateUserStatus(status)

        then: "기분은 sad"
        user.getUserStatus().feel == "sad"
    }
}
