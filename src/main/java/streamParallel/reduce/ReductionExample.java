package streamParallel.reduce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class ReductionExample {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 92),
                new Student("신용권", 95),
                new Student("정민지", 100)
        );

        //-- 1. 기본 집계메소드 sum()
        int sum1 = studentList.stream()
                .mapToInt(Student :: getScore)
                .sum();

        //-- 2. reduce(BinaryOperator<Integer> ac)
        int sum2 = studentList.stream()
                .map(Student :: getScore)
                .reduce((a,b)->a+b)
                .get();

        //-- 3. reduce(identity, op)
        int sum3 = studentList.stream()
                .map(Student :: getScore)
                .reduce(0, (a,b)->a+b);

        log.info("sum1: " + sum1);
        log.info("sum2: " + sum2);
        log.info("sum3: " + sum3);
    }
}

//------------------------------------------------------
@AllArgsConstructor
@Getter
class Student{
    private String name;
    private int score;
}
