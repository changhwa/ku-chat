package io.kuchat.server.common.vo

/**
 * 서버 처리 결과를 담는 VO
 */
class ResultVo {

    /** 결과 코드 ( 0: 성공  1: 실패) */
    def resultCode

    /** 결과메세지 */
    def resultMsg

    /** 반환될 데이터 */
    def data


}
