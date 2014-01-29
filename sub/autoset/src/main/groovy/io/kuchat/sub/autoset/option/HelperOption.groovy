package io.kuchat.sub.autoset.option

class HelperOption implements Option{

    @Override
    def job(def options) {
        println "-h : 옵션에 대한 설명을 보여줍니다.\n"
        if(options.size()<2){
            noOptions()
        } else {
            String option = options[1] //Helper의 경우 옵션은 1개임
            try{
                this."$option"(option)
            } catch (MissingMethodException e){ // 잘못된 옵션값이 넘어왔을 경우 옵션값을 입력하지 않은것과 동일하게 진행
                noOptions()
            }
        }
    }

    @Override
    def projectName(def option) {
        println """
                {$option} : 프로젝트 이름 입니다. (접두어 서버는 server-, 클라이언트는 client-)\n
                              ex) server-auth
                              ex) client-friend
                """
    }

    @Override
    def ide(def option) {
        println """
                {$option} : 사용하는 IDE 를 선택합니다.\n
                              1) eclipse : 이클립스를 사용합니다.
                              2) idea : Intellij를 사용합니다.
                """
    }

    @Override
    def projectType(def option) {
        println """
                {$option} : 해당 프로젝트에서 사용할 설정을 선택합니다.\n
                              1) jpa : SPRING + JPA + Hibernate 기반
                              2) mybatis : mybatis 기반
                              3) gmongo : Groovy Mongo 기반
                              4) smongo : Spring Data Mongo 기반
                              5) default : 기본 컴포넌트 스캔만을 지원 (Spring)
                """
    }

    @Override
    def noOptions() {
        projectName("projectName")
        ide("ide")
        projectType("projectType")
    }
}
