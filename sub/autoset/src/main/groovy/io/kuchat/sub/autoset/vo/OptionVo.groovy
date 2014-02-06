package io.kuchat.sub.autoset.vo

/**
 * 옵션 VO
 *
 * @author Changhwa Oh
 */
class OptionVo {

    /** Project 경로*/
    def projectPath

    /** 프로젝트 종류 (server인지 client인지) */
    def projectKind

    /** IDE 종류 */
    def ide

    /** 프로젝트 Type (jpa, default, 등)*/
    def projectType

}
