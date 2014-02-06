package io.kuchat.sub.autoset.template

/**
 * Spring Resources 파일
 *
 * @author Changhwa Oh
 */
class ResourceTemplate implements Template{

    @Override
    def template(options) {
        def resources = this."$options.projectType"(options)
        resources
    }

    def jpa(options){
'''<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence" version="2.0">

    <persistence-unit name="Kuchat">
        <properties>
            <property name="hibernate.connection.url" value="jdbc:mysql://127.0.0.1:3306/kuchat?useUnicode=true&amp;amp;characterEncoding=utf8"/>
            <property name="hibernate.connection.driver_class" value="com.mysql.jdbc.Driver"/>
            <property name="hibernate.connection.username" value="kuchat"/>
            <property name="hibernate.connection.password" value="@kuchat!"/>
            <property name="hibernate.archive.autodetection" value="class"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
            <property name="use_sql_comments" value="true" />
            <property name="hbm2ddl.auto" value="update"/>
        </properties>
    </persistence-unit>
</persistence>
'''
    }
}
