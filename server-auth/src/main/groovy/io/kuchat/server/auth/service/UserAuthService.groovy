package io.kuchat.server.auth.service

import io.kuchat.server.auth.domain.User
import io.kuchat.server.auth.repository.UserRepository
import io.kuchat.server.common.vo.ResultVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserAuthService implements AuthService{

    @Autowired
    UserRepository userRepository

    @Transactional
    @Override
    ResultVo login(User user) {

        ResultVo resultVo = new ResultVo()

        User findUser = userRepository.findByEmailAndPasswd(user.email, user.passwd)

        if(findUser != null){
            //login_cnt 를 0으로 업데이트
            findUser.loginCnt = 0
            user.loginCnt = 0
            resultVo.resultCode = 0
            resultVo.resultMsg = "로그인에 성공하였습니다"
        } else {
            //해당 email에 login_cnt를 1로 업데이트
            findUser = userRepository.findByEmail(user.email)
            if(findUser != null) {
                user.loginCnt = ++findUser.loginCnt
                resultVo.resultMsg = "비밀번호가 틀렸습니다"
            } else {
                resultVo.resultMsg = "아이디가 없습니다"
            }
            resultVo.resultCode = 1
        }
        resultVo.data = user
        resultVo
    }
}
