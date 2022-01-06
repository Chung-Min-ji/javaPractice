package IO.fileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/jeongminji/temp/file1.txt");
        FileWriter fw = new FileWriter(file, true); //true: 기존 파일 내용에 데이터 추가. true 지정하지 않으면 파일 덮어씀.

        fw.write("FileWriter는 한글로 된 "  + "\r\n");
        fw.write("문자열을 바로 출력할 수 있다." + "\r\n");
        fw.flush();
        fw.close();
        System.out.println("file saved.");
    }
}
