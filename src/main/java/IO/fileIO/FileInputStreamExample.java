package IO.fileIO;

import java.io.FileInputStream;

public class FileInputStreamExample {
    public static void main(String[] args) {
        // FileInputStream 객체는 생성될 때 파일과 직접 연결됨. (파일 개방, 파일 Open)
        // 만약 파일이 존재하지 않으면 FileNotFoundException 발생시키므로, try-catch 예외처리 필요.
        try{
            FileInputStream fis = new FileInputStream(
                    "/Users/jeongminji/IdeaProjects/javaPractice/src/main/java/IO/fileIO/FileInputStreamExample.java"
            );
            int data;
            while((data = fis.read()) != -1){
//                System.out.print(data); // read() 는 바이트값을 아스키 코드 (int) 로 리턴하므로, print() 하면 아스키코드값으로 출력됨.
                System.out.write(data); // write() 는 아스키코드를 문자로 변환해서 출력
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
