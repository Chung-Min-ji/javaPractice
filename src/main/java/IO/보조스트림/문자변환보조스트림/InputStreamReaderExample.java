package IO.보조스트림.문자변환보조스트림;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {
    public static void main(String[] args) throws IOException {
        // 콘솔로 입력한 한글을 Reader를 이용해서 읽고, 다시 콘솔로 출력.
        System.out.print("문자 입력 : ");
        InputStream is = System.in;
        // 바이트 기반 스트림(InputStream) 이지만, 입출력 데이터는 문자이므로
        // Reader 변환해주기 위한 보조스트림 연결.
        Reader reader = new InputStreamReader(is);

        int readCharNo;
        char[] cbuf = new char[100];
        while((readCharNo = reader.read(cbuf)) != -1){
            String data = new String(cbuf, 0, readCharNo);
            System.out.println(data);
        }
        reader.close();
    }
}
