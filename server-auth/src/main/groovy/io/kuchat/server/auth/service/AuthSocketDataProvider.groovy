package io.kuchat.server.auth.service

import io.kuchat.server.common.SocketDataProvider
import io.kuchat.server.common.vo.CommonVo
import net.sf.json.JSONObject
import org.springframework.stereotype.Component

//TODO 작성하고 보니 공통적으로 사용될듯 common으로 move ~
@Component
class AuthSocketDataProvider implements SocketDataProvider{

    @Override
    CommonVo socketJsonDataToVo(String json, Class classT) {

        Map<String, Class> classMap = new HashMap<>()
        classMap.put("data",classT)

        JSONObject jsonObject = JSONObject.fromObject(json).getJSONObject("json")

        //그루비 에서는 사실 형변환이 의미가 없음
        CommonVo commonVo = JSONObject.toBean(jsonObject
                ,CommonVo.class
                ,classMap) as CommonVo

        commonVo
    }
}
