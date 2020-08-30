//package org.example.config;
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.beans.PropertyVetoException;
//import java.util.Properties;
//
//import static org.hibernate.cfg.AvailableSettings.*;
//
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan("org.example")
//@PropertySource("classpath:db.properties")
//public class JpaConfig {
//    private static final Logger LOGGER = LoggerFactory.getLogger(JpaConfig.class);
//    private Environment env;
//
//    @Autowired
//    public void setEnv(Environment env) {
//        this.env = env;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        try {
//            dataSource.setDriverClass(env.getProperty("jdbc.driver"));
//            dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
//            dataSource.setUser(env.getProperty("jdbc.user"));
////            dataSource.setPassword(env.getProperty("jdbc.password"));
//        } catch (PropertyVetoException exc) {
//            LOGGER.error("!!!! DATASOURCE CANNOT BE CREATED !!!! " + exc);
//            return null;
//        }
//        return dataSource;
//    }
//
//    @Bean
//    @Autowired
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//        jpaTransactionManager.setEntityManagerFactory(emf);
//
//        return jpaTransactionManager;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean emf() {
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//
//        emf.setDataSource(dataSource());
//        emf.setPackagesToScan(env.getProperty("entities.location.folder"));
//        emf.setJpaProperties(properties());
//        emf.setJpaVendorAdapter(jpaVendorAdapter());
//
//        return emf;
//    }
//
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        return new HibernateJpaVendorAdapter();
//    }
//
//    @Bean
//    public Properties properties() {
//        Properties properties = new Properties();
//
//        properties.put(DIALECT, env.getProperty("hibernate.dialect"));
//        properties.put(FORMAT_SQL, env.getProperty("hibernate.format_sql"));
//        properties.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
//        properties.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
//
//        properties.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
//        properties.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
//        properties.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
//        properties.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
//        properties.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
//
//        return properties;
//    }
//}
