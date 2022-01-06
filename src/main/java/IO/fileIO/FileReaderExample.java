package IO.fileIO;

import java.io.FileReader;

public class FileReaderExample {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader(
                "/Users/jeongminji/IdeaProjects/javaPractice/src/main/java/IO/fileIO/FileReaderExample.java"
        );

        int readCharNo; // 읽은 바이트 '수' 저장
        char[] cbuf = new char[100]; // 읽은 데이터(바이트) 저장

        while ((readCharNo = fr.read(cbuf)) != -1) {
            String data = new String(cbuf, 0, readCharNo); // cbuf에 있는 문자들을 연결해서 문자열(String 객체)로 생성
            System.out.println(data);
        }

        fr.close();
    }

}
