package IO.보조스트림.문자변환보조스트림;

import java.io.*;

public class OutputStreamWriterExample {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("/Users/jeongminji/temp/file1.txt", true);
        Writer writer = new OutputStreamWriter(fos);

        String data = "바이트 출력 스트림을 문자 출력 스트림으로 변환 \r\n";
        writer.write(data);

        writer.flush();
        writer.close();
        System.out.println("file was saved.");

    }
}
