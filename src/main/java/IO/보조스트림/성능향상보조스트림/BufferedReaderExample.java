package IO.보조스트림.성능향상보조스트림;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedReaderExample {
    public static void main(String[] args) throws Exception{
        InputStream is = System.in;
        Reader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        System.out.print("input: ");
        String lineString = br.readLine(); // readLine() : 행 단위 문자열 한번에 읽기

        System.out.println("출력 : " + lineString);
    }
}
