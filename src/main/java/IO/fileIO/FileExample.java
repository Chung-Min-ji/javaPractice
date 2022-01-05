package IO.fileIO;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class FileExample {
    public static void main(String[] args) throws Exception{
        File dir = new File("/Users/jeongminji/temp/Dir");
        File file1 = new File("/Users/jeongminji/temp/file1.txt"); //경로 유효하지 않아도 컴파일에러 발생 X
        File file2 = new File("/Users/jeongminji/temp/file2.txt");
        // 파일 경로를 URI 객체로 생성해서 매개값으로 제공할 수 있음.
        // URI 지정시 'file://' 까지 필수로 입력
        File file3 = new File(new URI("file:///Users/jeongminji/temp/file3.txt"));

        if(!dir.exists()) {
            dir.mkdirs(); // mkdirs() : 경로상에 없는 모든 디렉토리를 생성
        }
        if(!file1.exists()) {
            file1.createNewFile();
        }
        if(!file2.exists()) {
            file2.createNewFile();
        }
        if(!file3.exists()) {
            file3.createNewFile();
        }

        File temp = new File("/Users/jeongminji/temp");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
        File[] contents = temp.listFiles(); //디렉토리에 포함된 모든 파일, 서브 dir 목록을 배열로 리턴

        System.out.println("날짜             시간      형태    크기   이름");
        System.out.println("-----------------------------------------");

        for(File file : contents){
            System.out.print(sdf.format(new Date(file.lastModified()))); //lastModified() : 마지막 수정 날짜,시간 리턴
            if(file.isDirectory()){ // 디렉토리인지 여부
                System.out.print("\t<DIR> \t\t\t" + file.getName());
            } else {
                System.out.print("\t\t\t" + file.length() + "\t" + file.getName());
            }
            System.out.println();
        } //enhanced-for


    }
}
