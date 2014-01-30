package io.kuchat.sub.autoset.vo

class OptionVo {

    def projectPath
    def projectKind // server  or  client
    def ide
    def projectType

    def getIde(){
        if(ide == "idea" || ide == "eclipse"){
            return ide
        }
    }

}
