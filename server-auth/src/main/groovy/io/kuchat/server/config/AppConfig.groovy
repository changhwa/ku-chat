package io.kuchat.server.config

import com.jolbox.bonecp.BoneCPDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.hibernate4.HibernateExceptionTranslator
import org.springframework.orm.jpa.JpaDialect
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.Database
import org.springframework.orm.jpa.vendor.HibernateJpaDialect
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.annotation.EnableTransactionManagement

import javax.persistence.EntityManagerFactory
import javax.sql.DataSource


@PropertySource("classpath:db.properties")
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories("io.kuchat.server")
@ComponentScan(basePackages = "io.kuchat.server")
@Configuration
class AppConfig {

    @Autowired
    private Environment env

    @Bean
    public DataSource dataSource(){
        BoneCPDataSource dataSource = new BoneCPDataSource()
        dataSource.setDriverClass(env.getProperty("jdbc.driverClass"))
        dataSource.setJdbcUrl(env.getProperty("jdbc.url"))
        dataSource.setUsername(env.getProperty("jdbc.username"))
        dataSource.setPassword(env.getProperty("jdbc.password"))
        dataSource.setIdleConnectionTestPeriodInMinutes(60)
        dataSource.setIdleMaxAgeInMinutes(240)
        dataSource.setMaxConnectionsPerPartition(30)
        dataSource.setMinConnectionsPerPartition(10)
        dataSource.setPartitionCount(3)
        dataSource.setAcquireIncrement(5)
        dataSource.setStatementsCacheSize(100)
        dataSource.setReleaseHelperThreads(3)

        dataSource
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        new HibernateExceptionTranslator()
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter()
        vendorAdapter.setGenerateDdl(true)
        vendorAdapter.setShowSql(false)
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect")
        vendorAdapter.setGenerateDdl(false)
        vendorAdapter.setDatabase(Database.MYSQL)

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean()
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter)
        entityManagerFactoryBean.setDataSource(dataSource())
        entityManagerFactoryBean.setPersistenceUnitName("Kuchat")
        entityManagerFactoryBean.setPackagesToScan("io.kuchat.server.*")
        entityManagerFactoryBean.afterPropertiesSet()
        entityManagerFactoryBean.getObject()
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager()
        JpaDialect jpaDialect = new HibernateJpaDialect()
        txManager.setEntityManagerFactory(entityManagerFactory())
        txManager.setJpaDialect(jpaDialect)
        txManager
    }

}
