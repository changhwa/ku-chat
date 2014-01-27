package io.kuchat.server

import groovy.util.logging.Slf4j
import io.kuchat.server.auth.domain.User
import io.kuchat.server.auth.service.AuthService
import io.kuchat.server.common.SocketDataProvider
import io.kuchat.server.common.vo.CommonVo
import io.kuchat.server.common.vo.ResultVo
import io.kuchat.server.config.AppConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.stereotype.Component

@Component
@Slf4j
class AuthApp {

    @Autowired
    AuthService userAuthService

    @Autowired
    SocketDataProvider authSocketDataProvider

    /**
     * 소켓을 구현 하고 데이터를 bind함
     */
    public void start(){
        //소켓부분 구현

        //데이터 bind
        String json = "{\n" +
                "   \"json\":{\n" +
                "      \"header\":\"auth\",\n" +
                "      \"actionType\":\"login\",\n" +
                "      \"data\":{\n" +
                "         \"id\":\"1\",\n" +
                "         \"pw\":\"1234\",\n" +
                "         \"email\":\"test1@narratage.com\"\n" +
                "      }\n" +
                "   }\n" +
                "}"
        CommonVo commonVo = authSocketDataProvider.socketJsonDataToVo(json, User.class)
        doAction(commonVo)
    }

    /**
     * Action을 실행함
     * @param commonVo
     */
    def doAction(CommonVo commonVo){
        String actionType = commonVo.actionType

        log.info(" Auth Action ")
        log.info(" ActionType == > " + actionType)

        ResultVo resultVo = userAuthService."$actionType"(commonVo.data)
    }


    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)
        AuthApp authApp = context.getBean("authApp")
        authApp.start()
    }
}
