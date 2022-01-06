package IO.보조스트림.객체입출력보조스트림;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStreamExample {
    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream("/Users/jeongminji/temp/objectSubStreamTest.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // 객체를 파일에 저장
        oos.writeObject(new Integer(10));
        oos.writeObject(new Double(3.14));
        oos.writeObject(new int[]{1,2,3});
        oos.writeObject(new String("abcd"));

        oos.flush(); oos.close(); fos.close(); // close 순서

        FileInputStream fis = new FileInputStream("/Users/jeongminji/temp/objectSubStreamTest.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // 출력(파일에 저장)된 순서와 동일한 순서로 객체 읽기
        Integer obj1 = (Integer)ois.readObject();
        Double obj2 = (Double)ois.readObject();
        int[] obj3 = (int[])ois.readObject();
        String obj4 = (String)ois.readObject();

        ois.close(); fis.close(); //close 순서**

        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3[0] + "," + obj3[1] + "," + obj3[2]);
        System.out.println(obj4);
    }
}
