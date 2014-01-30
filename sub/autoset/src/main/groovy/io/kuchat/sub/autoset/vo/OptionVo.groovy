package io.kuchat.sub.autoset.vo

class OptionVo {

    def projectKind // server  or  client
    def ide
    def projectType

    def getProjectKind() {
        return projectKind
    }

    def getIde(){
        if(ide == "idea" || ide == "eclipse"){
            return ide
        }
    }

}
