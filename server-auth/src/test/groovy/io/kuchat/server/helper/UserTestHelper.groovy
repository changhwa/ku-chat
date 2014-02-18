package io.kuchat.server.helper

import io.kuchat.server.auth.repository.UserRepository
import io.kuchat.server.config.AppConfig
import io.kuchat.server.user.repository.UserStatusRepository
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * User 테스트 데이터 초기화 & 셋팅용 클래스
 *
 * @author ChanghwaOh
 * @todo 공용화할 방법은 없을까? 연구과제
 */
class UserTestHelper implements  TestHelper {

    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)
    UserRepository userRepository = context.getBean("userRepository") as UserRepository
    UserStatusRepository userStatusRepository = context.getBean("userStatusRepository") as UserStatusRepository

    def helper(){

        List userList = new UserDummy().dummy()

        userList.each { it ->
            resetData(it)
            setupData(it)
        }
    }

    @Override
    def resetData(def t) {
        userRepository.delete(t)
        if(t.userStatus != null){
            userStatusRepository.delete(t.userStatus)
        }
    }

    @Override
    def setupData(def t) {
        userRepository.save(t)
        if(t.userStatus != null){
            userStatusRepository.save(t.userStatus)
        }
    }
}
