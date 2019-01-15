package com.vikramlc.didemo.config;

import com.vikramlc.didemo.examplebeans.FakeDataSource;
import com.vikramlc.didemo.examplebeans.FakeJmsDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("${com.user}")
    String user;

    @Value("${com.password}")
    String password;

    @Value("${com.dburl}")
    String url;

    @Value("${com.jms.user}")
    String jmsUser;

    @Value("${com.jms.password}")
    String jmsPassword;

    @Value("${com.jms.dburl}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(env.getProperty("COM_USER"));
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsDataSource fakeJmsDataSource() {
        FakeJmsDataSource fakeJmsDataSource = new FakeJmsDataSource();
        fakeJmsDataSource.setJmsUser(jmsUser);
        fakeJmsDataSource.setJmsPassword(jmsPassword);
        fakeJmsDataSource.setJmsUrl(jmsUrl);
        return fakeJmsDataSource;

    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }

}
