package com.eomcs.mylist.dao;

import com.eomcs.mylist.domain.Contact;

public interface ContactDao {

  // 인터페이스는 객체 메서드 호출 규칙을 정의하는 것이기 때문에 메서드를 작성할 때 메서드 몸체를 작성하지 말아야한다.
  // 메서드 바디가 없는 메서드를 추상 메서드라고 한다.(abstract)
  int countAll();

  Object[] findAll();

  void insert(Contact contact) throws Exception;

  Contact findByNo(int no);

  int update(int no, Contact contact) throws Exception;

  int delete(int no) throws Exception;
}











