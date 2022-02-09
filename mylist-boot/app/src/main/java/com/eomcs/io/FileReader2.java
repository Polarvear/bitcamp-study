package com.eomcs.io;

import java.io.FileReader;

//기존 코드를 자신의 코드인양 사용하기 위해 해당 클래스를 포함한다. 
public class FileReader2  {


  // 기존으 ㅣ클래스 포함
  FileReader in;
  //수퍼 클래스의 생성자는 바로 ㅏ용할 수 없다.
  // 서브 클래스의 생성자를 통해 사용해야한다.  
  public FileReader2(String filename) throws Exception{
    // 다음과 같이 수퍼클래스의 생성자를 호출해야한다.
    in = new FileReader(filename);
  }
  public String readLine() throws Exception {
    StringBuilder buf = new StringBuilder();
    int c;


    while ((c = in.read()) != -1) {// 파일에서 한 문자를 읽는다. 더이상 읽을 문자가 없으면 반복문을 종료하다.
      if (c == '\n') { // 만약 읽은 문자가 줄바꿈 명령이라면, 지금까지 읽은 CSV 데이터를 분석하여 Contact 객체에 담는다.
        return buf.toString();
      } else if ( c == '\r') { 
      } else { // 문자를 읽을 때 마다 버퍼에 임시 보관한다.
        buf.append((char) c);
      }
    }
    return buf.toString();
  }
  // 자원 해제하라는 요청이 들어오면 실제 일을 하는 객체에게 전달한다.
  public void close() throws Exception {
    in.close();
  }
}
