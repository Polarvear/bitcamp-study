package com.eomcs.oop.ex09.a1.after;

public  class Compile {
  public void m1() {

  }

  public static class C extends Compile {
    public void m2() {

    }
  }

  public static void main(String[] args) {
    Compile c = new C();
    c.m1();
    ((C)c).m2();

  }

}

