package io.kuchat.server.auth.service

import io.kuchat.server.auth.domain.User

public interface AuthService {

    User findUserById(User user)

}