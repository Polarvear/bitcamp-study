package com.eomcs.io.ex15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;

public class Exam0110 {
  public static void main(String[] args) throws Exception{


    Encoder encoder = Base64.getEncoder();

    File file = new File("./temp/photo2.jfif");
    FileInputStream in = new FileInputStream(file);
    FileWriter out = new FileWriter("./temp/photo2.txt");

    byte[] buf = new byte[(int) file.length()];
    int len  = in.read(buf); 
    System.out.printf("읽은 바이트 수: %d \n", len);

    String encodedStr = encoder.encodeToString(Arrays.copyOf(buf, len)); //버퍼에 꽉 안찰경우에는 안찬 부분 빼고 바꿈

    // 텍스트로 변환된 데이터를 파일로 출력하기
    out.write(encodedStr);

    in.close();
    out.close();
  }
}
