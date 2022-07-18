package com.tn.app;

import com.tn.magic.annotation.EnableStringTrimming;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableStringTrimming
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        var context = SpringApplication.run(Application.class, args);
        var stringUtilsService = context.getBean(StringUtilsService.class);
        System.out.println(stringUtilsService.concat("    hello   ", "world!  "));
        System.out.println(stringUtilsService.concat("hello", "world!  "));
        System.out.println(stringUtilsService.addWhiteSpaces("hello"));
        System.out.println(stringUtilsService.addWhiteSpaces(null));
        var intUtilsService = context.getBean(IntUtilsService.class);
        System.out.println(intUtilsService.add(1, 2));
    }
}
