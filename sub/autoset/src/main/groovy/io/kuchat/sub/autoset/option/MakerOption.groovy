package io.kuchat.sub.autoset.option

import io.kuchat.sub.autoset.vo.OptionVo

class MakerOption implements Option{

    private static final String CURRENT_PATH = System.getProperty("user.dir")
    OptionVo optionVo = new OptionVo()

    @Override
    def job(def options) {
        //TODO 빠르게 작성하느라 빠진 예외들 정리

        projectName(options)
        ide(options)
        projectType(options)
        optionVo
    }

    @Override
    def projectName(def option) {

        String name = option[1]

        if(name.startsWith("server-")||name.startsWith("client-")){
            String projectRootPath = new File(new File(CURRENT_PATH).parent).parent
            File file = new File(projectRootPath+"/"+name)
            file.mkdir()
            optionVo.projectKind = name.substring(0,6)
            println "$name 폴더가 만들어졌습니다."
        }

    }

    @Override
    def ide(def option) {
        optionVo.ide = option[2]
    }

    @Override
    def projectType(def option) {
        optionVo.projectType = option[3]
    }

    @Override
    def noOptions() {
        //TODO 아무 옵션값이 없거나 제대로 옵션값이 없을 경우 처리
        return null  
    }
}
