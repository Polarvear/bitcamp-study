package com.eomcs.mylist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 클라이언트 요청을 처리하는 역할
public class ContactController01 {
  //인스턴스 변수 => 모든 인스턴스 메서드가 공유한다
  String[] contacts = new String[5];
  int size = 0; 


  @GetMapping("/contact/list") // 이걸 요청하면 밑의 메소드를 호출해라
  public Object list() { // list() 호출
    //    String[] contacts = {
    //        "서버의 홍길동,  hong@test.com,  010-1111-1111, 삼성",
    //        "서버의 임꺽정,  GGuek@test.com, 010-2222-1111, LG",
    //        "서버의 김구  ,    9@test.com,     010-3333-1111, 현대"  
    //    };
    //    return contacts;
    String[]records = new String[size];
    for (int i = 0; i < size; i++) {
      records[i] = contacts[i];
    }
    return records;
  }
  @GetMapping("/contact/add")  // 이걸 요청하면 밑의 메소드를 호출해라
  public Object add(String name, String email, String tel, String company) {

    contacts[size++] = name + "," + email + "," + tel + "," +company;
    return size;

  }
  @GetMapping("/contact/get")  // 이걸 요청하면 밑의 메소드를 호출해라
  public Object get(String email) {
    for(int i = 0; i <=size; i++) {
      if (email.equals(contacts[i].split(",")[1])) {
        return contacts[i];
      }
    }
    return "";
  }
}

