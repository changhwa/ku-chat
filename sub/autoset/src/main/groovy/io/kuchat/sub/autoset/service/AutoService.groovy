package io.kuchat.sub.autoset.service

import groovy.util.logging.Slf4j
import io.kuchat.sub.autoset.vo.OptionVo

@Slf4j
class AutoService {

    private AutoService(){}

    AutoService(OptionVo optionVo){
        makeProjectFolder(optionVo)

    }

    /**
     * 프로젝트 폴더를 생성함
     * @param optionVo
     */
    def makeProjectFolder(OptionVo optionVo){
        File file = new File(optionVo.projectPath)
        file.mkdir()
        log.info("$optionVo.projectPath 에 폴더를 생성하였습니다.")
    }

}
