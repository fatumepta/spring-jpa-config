package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan("org.example")
@PropertySource("classpath:db.properties")
public class JpaConfig {
    private Environment env;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }
}
