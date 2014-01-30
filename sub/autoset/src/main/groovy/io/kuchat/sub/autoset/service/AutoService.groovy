package io.kuchat.sub.autoset.service

import groovy.util.logging.Slf4j
import io.kuchat.sub.autoset.template.GradleTemplate
import io.kuchat.sub.autoset.template.Template
import io.kuchat.sub.autoset.vo.OptionVo

@Slf4j
class AutoService {

    Template template

    private AutoService(){}

    AutoService(OptionVo optionVo){
        makeProjectFolder(optionVo)
        makeBuildGradle(optionVo)
    }

    /**
     * 프로젝트 폴더를 생성함
     * @param optionVo
     */
    def makeProjectFolder(OptionVo optionVo){
        File file = new File(optionVo.projectPath)
        file.mkdir()
        log.info("$optionVo.projectPath 에 프로젝트 폴더를 생성하였습니다.")
    }

    /**
     * build.gradle 파일을 생성함
     * @param optionVo
     */
    def makeBuildGradle(OptionVo optionVo){
        template = new GradleTemplate()
        def buildContent = template.template(optionVo)
        File file = new File(optionVo.projectPath+"/build.gradle")
        file << buildContent
        log.info("build.gradle 파일을 생성하였습니다")
    }


}
