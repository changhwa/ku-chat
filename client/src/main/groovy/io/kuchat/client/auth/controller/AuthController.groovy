package io.kuchat.client.auth.controller

import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j
import io.kuchat.client.auth.service.AuthService
import io.kuchat.client.auth.vo.AuthVo
import io.kuchat.client.common.connect.SocketClient
import io.kuchat.client.common.vo.CommonVo
import net.sf.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
@Slf4j
class AuthController {

    @Autowired
    AuthService authService

    def login (AuthVo authVo){
        CommonVo commonVo = authService.login(authVo)
        def json = JSONObject.fromObject(commonVo)
        String result = new SocketClient().client(json.toString()+"\n", 9000)
        clientData(result)
    }

    def clientData(String result){
        JSONObject jsonObject = JSONObject.fromObject(result)
        println jsonObject.toString()
        println jsonObject.get("actionType")
        println jsonObject.actionType
        println jsonObject.data.data.email

    }

}
