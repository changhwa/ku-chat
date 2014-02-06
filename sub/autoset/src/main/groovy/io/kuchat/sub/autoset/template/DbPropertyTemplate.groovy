package io.kuchat.sub.autoset.template

/**
 * db.properties 템플릿
 *
 * @author Changhwa Oh
 */
class DbPropertyTemplate implements Template{

    @Override
    def template(options) {
'''
jdbc.driverClass=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://127.0.0.1:3306/kuchat?useUnicode=true&amp;characterEncoding=utf8
jdbc.username=kuchat
jdbc.password=@kuchat!
'''

    }
}
