package io.kuchat.sub.autoset

import io.kuchat.sub.autoset.option.HelperOption
import io.kuchat.sub.autoset.option.Option

//TODO 차후 Gradle Task로 확장함
class AutoApp {

    private AutoApp(){}

    AutoApp(def optionType, def optionValues){

        Option option

        if(optionType == "-h") {
            option = new HelperOption()
            option.job(optionValues)
        }

    }

    public static void main(def args) {

        if(args.size() < 1){
            //아무런 매개값이 들어오지 않았을때 출력될 멘트
            println "error!"
            System.exit(0)
        }
        new AutoApp(args[0], args)

        //옵션에 따른 실행

        //변수체크

        //build.gradle 생성

        //프로젝트 구조

        //JavaConfig

        //조건에 따른 resources 생성

        //logging

        //common 복사

    }
}
