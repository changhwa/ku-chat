package io.kuchat.sub.autoset.option

import io.kuchat.sub.autoset.vo.OptionVo

class MakerOption implements Option{

    private static final String CURRENT_PATH = System.getProperty("user.dir")
    OptionVo optionVo = new OptionVo()

    @Override
    def job(def options) {
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
            optionVo.projectPath = projectRootPath+"/"+name
            optionVo.projectKind = name.substring(0,6)
        } else {
            println "프로젝트 이름은 server- 나 client- 로 시작해야합니다"
            System.exit(1)
        }

    }

    @Override
    def ide(def option) {
        def ide = option[2]
        if(ide == "idea" || ide == "eclipse"){
            optionVo.ide = ide
        } else {
            println "ide 옵션은 idea 나 eclipse 여야 합니다"
            new File(optionVo.projectPath).deleteDir()
            System.exit(1)
        }

    }

    @Override
    def projectType(def option) {
        optionVo.projectType = option[3]
    }

    @Override
    def noOptions() {
        println "옵션이 없습니다. -h 를 사용해서 도움말을 참고하세요"
        System.exit(1)
    }
}
