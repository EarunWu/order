package com.example.oder_putout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class OderPutoutApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(OderPutoutApplication.class, args);
        System.out.println("run succeed");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        System.out.println("外部tomcat,chapter启动!");
        return application.sources(OderPutoutApplication.class);
    }

}
