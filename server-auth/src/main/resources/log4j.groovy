log4j {

    rootLogger="DEBUG, stdout"

    log4j.appender.stdout="org.apache.log4j.ConsoleAppender"
    log4j.appender.'stdout.Target'="System.out"
    log4j.appender.'stdout.layout'="org.apache.log4j.PatternLayout"
    log4j.appender.'stdout.layout.ConversionPattern'="%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"
}