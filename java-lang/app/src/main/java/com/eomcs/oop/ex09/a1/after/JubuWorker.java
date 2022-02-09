// Worker 구현체 
package com.eomcs.oop.ex09.a1.after;

public class JubuWorker implements Worker {
  // 인터페이스 구현체는 인터페이스에 선언된 모든 메서드를 구현해야 한다.
  @Override
  public void execute() {
    doSsingSsing();
  }
  public String doSsingSsing() {
    return "주부가 일을 합니다.";
  }
}

