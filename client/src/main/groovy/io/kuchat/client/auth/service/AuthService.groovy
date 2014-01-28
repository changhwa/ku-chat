package io.kuchat.client.auth.service

import io.kuchat.client.auth.vo.AuthVo
import io.kuchat.client.common.vo.CommonVo
import net.sf.json.JSONObject
import org.springframework.stereotype.Component

@Component
class AuthService {

    def login (AuthVo authVo){

        authVo.id = 1 //TODO 제거
        CommonVo commonVo = new CommonVo()
        commonVo.header = "auth"
        commonVo.actionType = "login"
        commonVo.data = authVo

        commonVo
    }
}
