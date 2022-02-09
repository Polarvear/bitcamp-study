package com.eomcs.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class ServerApp {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(ServerApp.class, args);

  }
  @RequestMapping("/help")
  public String help() {
    StringBuilder strBuilder = new StringBuilder();
    strBuilder.append("<!DOCTYPE html>\n");
    strBuilder.append("<html><head><meta charset='UTF-8'><title>웹 계산기</title></head>\n");
    strBuilder.append("<body>\n");
    strBuilder.append("<h1>[웹계산기도움말]</h1>\n");
    strBuilder.append("사용법<br>\n");
    strBuilder.append("URL형식 =>loclahost:8080/calc?op=연산자&<br>\n");
    strBuilder.append("예) http://\n");
    strBuilder.append("</body></html>\n");
    return strBuilder.toString();
  }
}