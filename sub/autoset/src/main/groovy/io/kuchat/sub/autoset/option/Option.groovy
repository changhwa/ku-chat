package io.kuchat.sub.autoset.option

public interface Option {

    def job(def options)
    def projectName(def option)
    def ide(def option)
    def projectType(def option)
    def noOptions()

}