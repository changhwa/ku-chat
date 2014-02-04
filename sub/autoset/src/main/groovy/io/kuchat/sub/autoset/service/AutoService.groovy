package io.kuchat.sub.autoset.service

import groovy.util.logging.Slf4j
import io.kuchat.sub.autoset.template.GradleTemplate
import io.kuchat.sub.autoset.template.ResourceTemplate
import io.kuchat.sub.autoset.template.SpringJpaTemplate
import io.kuchat.sub.autoset.template.Template
import io.kuchat.sub.autoset.vo.OptionVo

@Slf4j
class AutoService {

    Template template

    private AutoService(){}

    AutoService(OptionVo optionVo){
        makeProjectFolder(optionVo)
        makeBuildGradle(optionVo)
        playGradleBuild(optionVo)
        makeAppConfig(optionVo)
        makeAppResource(optionVo)
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

    /**
     * Gradle의 기본적인 Build를 실행함
     * @param optionVo
     */
    def playGradleBuild(OptionVo optionVo){
        //TODO GRADLE_HOME을 설정하는 방안 구상 , 또는 gradlew 사용
        println " /Users/changhwaoh/gradle/gradle-1.10/bin/gradle build".execute(
                null, new File(optionVo.projectPath)).text
    }

    /**
     * 스프링 설정파일을 생성함
     * @param optionVo
     * @return
     */
    def makeAppConfig(OptionVo optionVo){

        template = new SpringJpaTemplate()

        def appConfig = template.template(optionVo)
        def projectKind = optionVo.projectKind
        def configFilePath = optionVo.projectPath+
                "/src/main/groovy/io/kuchat/$projectKind/config"
        new File(configFilePath).mkdirs()
        def appConfigFile = new File(configFilePath+"/AppConfig.groovy")
        appConfigFile << appConfig
    }

    /**
     * 스프링 Resource 파일을 생성함
     * @param optionVo
     * @return
     */
    def makeAppResource(OptionVo optionVo){

        template = new ResourceTemplate()
        def resources = template.template(optionVo)

        if(optionVo.projectType == "jpa"){
            def resourcePath = optionVo.projectPath + "/src/main/resources/META-INF"
            new File(resourcePath).mkdirs()
            def persistence = new File(resourcePath+"/persistence.xml")
            persistence << resources
        }

        log.info "resource 파일 생성 완료"
    }



}
