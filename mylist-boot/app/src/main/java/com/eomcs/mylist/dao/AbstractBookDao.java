package com.eomcs.mylist.dao;

import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;

public abstract class AbstractBookDao implements BookDao{
  // 추상클래스는 추상 메서드로 해야한다.


  protected ArrayList bookList = new ArrayList();
  //서브클래스에서 접근해야하는 필드라면 접근 범위를 protected로 설정한다



  //save()는 서브클래스 마다 방법이 다르다.
  //그래서 수퍼클래스에서 save매서드를 구현해도 의미가 없다!
  //이런 method 를 abstract method로 선언한다.
  // 서브클래스에서 오버라이딩 할 ㅅ ㅜ있도록 접근 가능해야한다. 
  // 서브클래스가 다른 패키지에 있을 수있다.
  // 이런 경우 메서드의 접근 범위를 protected로 한다. 
  protected abstract void save() throws Exception;

  @Override
  public int countAll() {
    return bookList.size();
  }

  @Override
  public Object[] findAll() {
    return bookList.toArray();
  }

  @Override
  public void insert(Book book) throws Exception {
    bookList.add(book);
    save();
  }

  @Override
  public Book findByNo(int no) {
    if (no < 0 || no >= bookList.size()) {
      return null;
    }
    return (Book) bookList.get(no);
  }

  @Override
  public int update(int no, Book book) throws Exception {
    if (no < 0 || no >= bookList.size()) {
      return 0;
    }
    bookList.set(no, book);
    save();
    return 1;
  }

  @Override
  public int delete(int no) throws Exception {
    if (no < 0 || no >= bookList.size()) {
      return 0;
    }
    bookList.remove(no);
    save();
    return 1;
  }
  @Override
  public void increaseViewCount(int no) throws Exception {
    Book book = findByNo(no);
    save();
  }

}











