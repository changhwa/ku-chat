package io.kuchat.server.helper

import io.kuchat.server.auth.domain.User
import spock.lang.Specification


class UserTestHelperTest extends Specification{

    def "Helper Test"(){

        given: ""
        TestHelper testHelper = new UserTestHelper()

        when: ""
        testHelper.helper()


        then: ""
        1==1

    }

}
