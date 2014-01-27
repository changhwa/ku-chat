package io.kuchat.server.auth.service

import io.kuchat.server.auth.domain.User
import io.kuchat.server.common.vo.ResultVo

public interface AuthService {

    ResultVo login(User user)

}