package com.vikramlc.didemo.config;

import com.vikramlc.didemo.examplebeans.FakeDataSource;
import com.vikramlc.didemo.examplebeans.FakeJmsDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfig {

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
        fakeDataSource.setUser(user);
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

}
