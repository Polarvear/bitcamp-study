package com.eomcs.mylist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext beanContainer) {
    return args -> {
      System.out.println("Bean container 가 생성한 객체(Bean container에 들어있는 객체)");
      String[] beanNames = beanContainer.getBeanDefinitionNames();
    };
  }

  @RequestMapping("/hello")
  String hello() {
    return "Hello World!";
  }



}