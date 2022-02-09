package com.eomcs.io;

import java.io.FileWriter;

// 기존의 FileWriter 클래스를 연결하여 마치 자신의 코드인양 사용한다~
public class FileWriter2 {
  // 실제 파일로 데이터 출력을 실행할 객체를 포함한다
  FileWriter out;

  // 이 클래스의 생성자를 통해 fileWriter 객체를 준비한다
  public FileWriter2(String filename ) throws Exception {
    out = new FileWriter(filename);
  }
  public void println(String str)  throws Exception {
    out.write(str + "\n");  
  }
  // 자원을 해제시키는 일은 실제 파일 출력을 수행하는 객체에게 넘긴다

  public void close() throws Exception{ // 이게 위임임
    out.close();
  }
}
