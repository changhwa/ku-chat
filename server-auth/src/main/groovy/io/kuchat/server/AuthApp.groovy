package io.kuchat.server

import groovy.util.logging.Slf4j
import io.kuchat.server.auth.domain.User
import io.kuchat.server.auth.service.AuthService
import io.kuchat.server.config.AppConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.stereotype.Component

@Component
@Slf4j
class AuthApp {

    @Autowired
    AuthService userAuthService

    public void start(){
        User user = new User()
        user.id = 1
        user = userAuthService.findUserById(user)
        println user.name
        log.info "Test"
    }


    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)
        AuthApp authApp = context.getBean("authApp")
        authApp.start()
    }
}
