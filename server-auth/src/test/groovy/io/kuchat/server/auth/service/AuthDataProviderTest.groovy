package io.kuchat.server.auth.service

import io.kuchat.server.auth.domain.User
import io.kuchat.server.common.SocketDataProvider
import io.kuchat.server.common.vo.CommonVo
import io.kuchat.server.config.AppConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = AppConfig.class)
class AuthDataProviderTest extends Specification{

    @Autowired
    SocketDataProvider authDataProvider

    def "JSON 데이터 변환"(){

        given: "해당 json 데이터를 받아왔다 가정하고"
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

        when: "CommonVO 로 변환을 시도할때"
        CommonVo commonVo = authDataProvider.socketJsonDataToVo(json,User.class)

        then: ""
        commonVo.header == "auth"
        commonVo.data.email == "test1@narratage.com"


    }
}
