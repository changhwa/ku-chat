package io.kuchat.server.common

import io.kuchat.server.common.vo.CommonVo

/**
 * 소켓에서 넘어온 데이터를 Domain이나 VO로 가공함
 * 해당 인터페이스를 구현함
 */
public interface SocketDataProvider {

    /**
     * 소켓에서 넘어온 JSON Data를 CommonVO 에 담는다
     * @param json 소켓에서 넘어온 JSON 데이터
     * @param classT 변환할 도메인
     * @return the CommonVO
     */
    public CommonVo socketJsonDataToVo(String json, Class classT)

}