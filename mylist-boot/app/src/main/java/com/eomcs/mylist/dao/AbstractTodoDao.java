package com.eomcs.mylist.dao;

import com.eomcs.mylist.domain.Todo;
import com.eomcs.util.ArrayList;

public abstract class AbstractTodoDao implements TodoDao{
  // 추상클래스는 추상 메서드로 해야한다.


  protected ArrayList todoList = new ArrayList();
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
    return todoList.size();
  }

  @Override
  public Object[] findAll() {
    return todoList.toArray();
  }

  @Override
  public void insert(Todo todo) throws Exception {
    todoList.add(todo);
    save();
  }

  @Override
  public Todo findByNo(int no) {
    if (no < 0 || no >= todoList.size()) {
      return null;
    }
    return (Todo) todoList.get(no);
  }

  @Override
  public int update(int no, Todo todo) throws Exception {
    if (no < 0 || no >= todoList.size()) {
      return 0;
    }
    todoList.set(no, todo);
    save();
    return 1;
  }

  @Override
  public int delete(int no) throws Exception {
    if (no < 0 || no >= todoList.size()) {
      return 0;
    }
    todoList.remove(no);
    save();
    return 1;
  }
  @Override
  public int updateDone(int no, boolean done) throws Exception {
    if (no < 0 || no >= todoList.size()) {
      return 0;
    }
    ((Todo) todoList.get(no)).setDone(done);
    save();
    return 1;
  }

}











