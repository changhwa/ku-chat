package io.kuchat.sub.autoset.option

/**
 * 옵션에 대해 정의할 interface
 *
 * @author Changhwa Oh
 */
public interface Option {

    /**
     * 각 옵션 실행
     * @param options
     * @return
     */
    def job(def options)

    /**
     * 프로젝트 이름, 경로 정의
     * @param option
     * @return
     */
    def projectName(def option)

    /**
     * IDE 정의
     * @param option
     * @return
     */
    def ide(def option)

    /**
     * 프로젝트 성격 정의
     * @param option
     * @return
     */
    def projectType(def option)

    /**
     * 옵션값이 없을 경우 처리
     * @return
     */
    def noOptions()

}