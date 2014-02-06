package io.kuchat.sub.autoset.template

/**
 * 프로젝트 탬플릿을 생성한다.
 *
 * @author ChanghwaOh
 */
interface Template {

    /**
     * 탬플릿이 생성됨
     * @param options 대치될 값
     * @return
     */
    def template(def options)
}
