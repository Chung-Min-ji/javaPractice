package streamParallel.mapping;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
// mapXXX() 메소드는 요소를 대체하는 요소로 구성된 새로운 스트림 리턴
public class MapExample {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("정민지", 30)
        );

        studentList.stream()
                .mapToInt(Student :: getScore)
                .forEach(s -> log.info("{}", s));
    }

}
