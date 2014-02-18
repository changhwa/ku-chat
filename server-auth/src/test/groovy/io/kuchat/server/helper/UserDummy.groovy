package io.kuchat.server.helper

import io.kuchat.server.auth.domain.User
import io.kuchat.server.user.domain.UserStatus

/**
 * 더미 데이터 생성용
 */
class UserDummy {

    List dummy(){

        User user1 = new User()
        user1.email = "test1@a.com"
        user1.name = "test1"
        user1.passwd = "test1!"
        user1.loginCnt = 0

        User user2 = new User()
        user2.email = "test2@b.com"
        user2.passwd = "test2!"
        user2.name = "test2"
        user2.loginCnt = 2

        UserStatus userStatus = new UserStatus()
        userStatus.email = "test2@b.com"
        userStatus.feel = "smile"
        userStatus.msg = "test ing.."
        user2.userStatus = userStatus

        List userList = new ArrayList()
        userList.add(user1)
        userList.add(user2)
        userList
    }
}
