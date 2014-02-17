package io.kuchat.sub.autoset.template


class GradleTemplate implements Template{

    @Override
    def template(def options) {

        def ide = options[0]
        def name = options[1]

        def buildContent = """

            apply plugin:'application'
            apply plugin: 'groovy'
            apply plugin: '$ide'
            apply plugin: 'java'

            sourceCompatibility = '1.7'
            targetCompatibility = '1.7'

            group = 'io.kuchat.$name'
            version = '0.1'


            ext{
                hibernateVersion = "4.2.2.Final"
                springVersion = "3.2.6.RELEASE"
            }

            repositories {
                mavenCentral()
                mavenLocal()
                maven { url "http://oss.sonatype.org/content/repositories/snapshots/" }
            }


            dependencies {
                compile fileTree(dir: 'lib', include: '**/*.jar')
                compile 'org.codehaus.groovy:groovy-all:2.1.9'
                compile 'log4j:log4j:1.2.17'
                compile 'org.slf4j:slf4j-api:1.7.5'
                compile 'org.slf4j:slf4j-log4j12:1.7.5'
                compile 'org.springframework.data:spring-data-jpa:1.3.4.RELEASE'
                compile 'org.hibernate:hibernate-core:4.2.2.Final'
                compile 'org.hibernate.javax.persistence:hibernate-jpa-2.1-api:1.0.0.Draft-16'
                compile 'org.hibernate:hibernate-entitymanager:4.2.2.Final'
                compile 'org.springframework:spring-core:3.2.6.RELEASE'
                compile 'org.springframework:spring-context:3.2.6.RELEASE'
                compile 'org.springframework:spring-aop:3.2.6.RELEASE'
                compile 'org.springframework:spring-test:3.2.6.RELEASE'
                compile 'org.springframework:spring-web:3.2.6.RELEASE'
                compile 'org.springframework:spring-webmvc:3.2.6.RELEASE'
                compile 'org.springframework:spring-tx:3.2.6.RELEASE'
                compile 'org.springframework:spring-context-support:3.2.6.RELEASE'
                compile 'org.springframework:spring-orm:3.2.6.RELEASE'
                compile 'org.springframework:spring-jms:3.2.6.RELEASE'
                compile 'org.springframework:spring-aspects:3.2.6.RELEASE'
                compile 'org.springframework:spring-jdbc:3.2.6.RELEASE'
                compile 'org.springframework:spring-beans:3.2.6.RELEASE'
                compile 'org.aspectj:aspectjweaver:1.7.0'
                compile 'cglib:cglib-nodep:2.2.2'
                compile 'org.apache.poi:poi:3.8'
                compile 'org.apache.poi:poi-ooxml:3.8'
                compile 'org.hibernate:hibernate-validator:4.3.0.Final'
                compile 'joda-time:joda-time:2.2'
                compile 'mysql:mysql-connector-java:5.1.18'
                compile 'org.hsqldb:hsqldb:2.3.0'
                compile 'com.jolbox:bonecp:0.7.1.RELEASE'
                compile 'net.sf.json-lib:json-lib:2.4:jdk15'
                testCompile "org.spockframework:spock-core:1.0-groovy-2.0-SNAPSHOT"
                testCompile "org.spockframework:spock-spring:1.0-groovy-2.0-SNAPSHOT"
                testCompile 'org.hamcrest:hamcrest-all:1.3'
            }

            sourceSets {
                main {
                    groovy {
                        srcDirs = ['src/main/groovy']
                    }
                }

                test {
                    groovy {
                        srcDirs = ['src/test/groovy']
                    }
                }
            }

            [compileGroovy, compileTestGroovy]*.options*.encoding = 'UTF-8'

            sourceSets.main.output.resourcesDir = sourceSets.main.output.classesDir
            sourceSets.test.output.resourcesDir = sourceSets.test.output.classesDir

            task initProject {
                    project.sourceSets*.allSource.srcDirTrees.flatten().dir.each { dir ->
                    dir.mkdirs()
                }
            }
        """
        buildContent
    }
}
