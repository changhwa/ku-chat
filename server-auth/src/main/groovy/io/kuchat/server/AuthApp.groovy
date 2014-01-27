package io.kuchat.server

import groovy.util.logging.Slf4j
import io.kuchat.server.auth.domain.User
import io.kuchat.server.auth.service.AuthService
import io.kuchat.server.common.SocketDataProvider
import io.kuchat.server.common.vo.CommonVo
import io.kuchat.server.common.vo.ResultVo
import io.kuchat.server.config.AppConfig
import net.sf.json.JSONObject
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
        def server = new ServerSocket(9000)

        while (true){
            server.accept { socket ->
                log.info ("Connection ...")
                socket.withStreams { input, output ->
                    def inputStream = input.newReader()
                    String json = inputStream.readLine()
                    log.info("json data : => $json")
                    output << recevie(json)
                }
                log.info ("the end...")
            }
        }
    }

    /**
     * 소켓으로 부터 데이터를 받음
     * @param json
     */
    def recevie(String json) {
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

        //TODO 리팩토링 해야할듯.. doAction에 어울리지 않음
        commonVo.data = resultVo
        JSONObject.fromObject(commonVo)
    }


    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)
        AuthApp authApp = context.getBean("authApp")
        authApp.start()
    }
}
