package IO.보조스트림.성능향상보조스트림;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputSteamExample {
    public static void main(String[] args) throws Exception{
        long start = 0;
        long end = 0;

        FileInputStream fis1 = new FileInputStream(
                "/Users/jeongminji/temp/test.png");
        start = System.currentTimeMillis();
        while(fis1.read() != -1){
            ;;
        }
        end = System.currentTimeMillis();
        System.out.println("without 보조스트림 : " + (end-start) + "ms");
        fis1.close();

        FileInputStream fis2 = new FileInputStream(
                "/Users/jeongminji/temp/test.png");
        BufferedInputStream bis = new BufferedInputStream(fis2); //버퍼스트림 생성
        start = System.currentTimeMillis();
        while(bis.read() != -1){;;}
        end = System.currentTimeMillis();
        System.out.println("with 보조스트림 : " + (end-start) + "ms");
        // 닫는 순서 : 보조스트림 -> 입출력스트림
        bis.close();
        fis2.close();
    }
}
