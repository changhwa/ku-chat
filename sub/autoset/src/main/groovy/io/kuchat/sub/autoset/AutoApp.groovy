package io.kuchat.sub.autoset

import io.kuchat.sub.autoset.option.HelperOption
import io.kuchat.sub.autoset.option.MakerOption
import io.kuchat.sub.autoset.option.Option
import io.kuchat.sub.autoset.service.AutoService
import io.kuchat.sub.autoset.vo.OptionVo

//TODO 차후 Gradle Task로 확장함
class AutoApp {

    static OptionVo optionVo = new OptionVo()

    private AutoApp(){}

    AutoApp(def optionType, def optionValues){

        Option option

        if(optionType == "-h") { //Helper
            option = new HelperOption()
            option.job(optionValues)
        } else if (optionType == "-m"){ //Make
            option = new MakerOption()
            optionVo = option.job(optionValues)
        }

    }

    public static void main(def args) {

        if(args.size() < 1){
            //아무런 매개값이 들어오지 않았을때 출력될 멘트
            println "error!"
            System.exit(0)
        }
        new AutoApp(args[0], args)
        new AutoService(optionVo)


    }
}
