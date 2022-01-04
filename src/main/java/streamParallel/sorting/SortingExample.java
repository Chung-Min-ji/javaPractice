package streamParallel.sorting;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class SortingExample {
    public static void main(String[] args) {
        // 숫자 요소일 경우
        IntStream intStream = Arrays.stream(new int[] {5, 3, 2, 1, 4});
        intStream
                .sorted()   // 숫자를 오름차순 정렬
                .forEach(n->log.info("{}", n));
        log.info("----------------");

        // 객체 요소일 경우 (Comparable 인터페이스 implements 한 객체)
        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 30),
                new Student("신용권", 10),
                new Student("정민지", 90)
        );

        studentList.stream()
                .sorted()   // 정수 기준으로 오름차순 정렬
                .forEach(s -> log.info("{}", s.getScore()));
        log.info("---------------");

        studentList.stream()
                .sorted(Comparator.reverseOrder())  // 정수 기준 내림차순 정렬
                .forEach(s -> log.info("{}", s.getScore()));

    }
}
