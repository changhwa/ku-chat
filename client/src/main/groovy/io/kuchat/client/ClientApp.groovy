package io.kuchat.client

import io.kuchat.client.config.AppConfig
import io.kuchat.client.auth.view.LoginFrame
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.stereotype.Component

//TODO 전체적으로 Refactoring 해야됨

@Component
class ClientApp {

    @Autowired
    LoginFrame loginFrame

    def start(){
        loginFrame.loginViewFrame()
    }


    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)
        ClientApp clientApp = context.getBean("clientApp")
        clientApp.start()
    }
}
