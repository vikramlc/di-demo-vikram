package com.vikramlc.didemo;

import com.vikramlc.didemo.controllers.ConstructorInjectedController;
import com.vikramlc.didemo.controllers.MyController;
import com.vikramlc.didemo.controllers.PropertyInjectedController;
import com.vikramlc.didemo.controllers.SetterInjectedController;
import com.vikramlc.didemo.examplebeans.FakeDataSource;
import com.vikramlc.didemo.examplebeans.FakeJmsDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

        MyController controller = (MyController) ctx.getBean("myController");

        FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUser());

        FakeJmsDataSource fakeJmsDataSource = (FakeJmsDataSource) ctx.getBean(FakeJmsDataSource.class);
        System.out.println(fakeJmsDataSource.getJmsUser());

        /*
        System.out.println(controller.hello());
        System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
        System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
        */

    }

}

