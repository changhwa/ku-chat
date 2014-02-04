package io.kuchat.sub.autoset.template

class DbPropertyTemplate implements Template{

    @Override
    def template(options) {
'''
jdbc.driverClass=core.log.jdbc.driver.MysqlDriver
jdbc.url=jdbc:mysql://127.0.0.1:3306/kuchat?useUnicode=true&amp;characterEncoding=utf8
jdbc.username=kuchat
jdbc.password=@kuchat!
'''

    }
}
