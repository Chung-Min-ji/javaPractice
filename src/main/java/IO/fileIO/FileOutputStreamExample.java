package IO.fileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {
    public static void main(String[] args) throws IOException {
        // 파일 복사 예제.
        // 원본 파일에서 읽은 바이트를 바로 타겟 파일로 저장하는 원리
        String originalFileName = "/Users/jeongminji/IdeaProjects/javaPractice/src/main/resources/images/test.png";
        String targetFileName = "/Users/jeongminji/temp/test.png";

        FileInputStream fis = new FileInputStream(originalFileName);
        FileOutputStream fos = new FileOutputStream(targetFileName);

        int readByteNo; // 읽은 바이트 '수' 저장
        byte[] readBytes = new byte[100]; // 실제 읽은 바이트 저장(binary). 바가지!

        while((readByteNo = fis.read(readBytes)) != -1){
            fos.write(readBytes, 0, readByteNo);
        }

        fos.flush();
        fos.close();
        fis.close();

        System.out.println("copied");
    }
}
