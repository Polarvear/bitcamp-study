// 추상 클래스와 추상 메서드의 활용
package com.eomcs.oop.ex07.a;

abstract class Letter1 {

  // 수퍼 클래스는 서브 클래스에게 구현된 멤버를 상속해준다.
  String content;

  public void setContent(String content) {
    this.content = content;
  }

  // 수퍼 클래스에서 기능이 어떻게 동작하는지 정의한다.
  // => 템플릿의 역할을 하는 메서드를 수퍼 클래스에 둔다.
  // => 자세한 구현은 서브 클래스에 맡긴다.
  public void print() { // <== 템플릿 메서드 디자인 패턴에서 "템플릿 메서드"에 해당한다. 
    this.printHeader();
    System.out.println(this.content);
    System.out.println();
    System.out.printf("              from %s!\n", this.getSign());
    System.out.println();
    this.printFooter();
  }

  // 세부 사항에 대한 것은
  // 서브 클래스에게 구현을 맡긴다.
  public abstract void printHeader();
  public abstract void printFooter();
  public abstract String getSign();
}

// 상세한 기능에 대한 구현은 다음과 같이 서브 클래스에게 맡긴다.
class Bill extends Letter1 {

  @Override
  public void printHeader() {
    System.out.println("----------고지서입니다---------");
  }

  @Override
  public String getSign() {
    return "한국전력공사";
  }

  @Override
  public void printFooter() {
    System.out.println("-----------전력공사 드림----------");

  }
}

public class Exam05 {
  public static void main(String[] args) {
    Letter1 letter = new Bill();
    letter.setContent("이번달 전기요금은 54,500원 입니다.");
    letter.print();
  }
}
