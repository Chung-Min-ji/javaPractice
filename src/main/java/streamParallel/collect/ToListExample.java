package streamParallel.collect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class ToListExample {
    public static void main(String[] args) {
        List<Student> totalList = Arrays.asList(
                new Student("홍길동", 10, Student.Sex.MALE),
                new Student("김수애", 6, Student.Sex.FEMALE),
                new Student("신용권", 7, Student.Sex.MALE),
                new Student("정민지", 10, Student.Sex.FEMALE)
        );

        // 남학생들만 묶어 List생성
        //--1. 전체 학생 List 에서 Stream 얻기
        List<Student> maleList = totalList.stream()
                //--2. 남학생만 필터링해서 Stream 얻기 (중간처리)
                .filter(s -> s.getSex() == Student.Sex.MALE)
                //--3-1. List에 Student 를 수집하는 Collector 얻어서,
                //--3-2. collect() 로 새로운 list 얻기
                .collect(Collectors.toList());
        maleList.forEach(s -> log.info("{}", s.getName()));

        log.info("------------------------");

        // 여학생들만 묶어 HashSet 생성
        //--1. 전체 학생 List 에서 Stream 얻기
        Set<Student> femaleSet = totalList.stream()
                //--2. 여학생만 필터링해서 Stream 얻기 (중간처리)
                .filter(s -> s.getSex() == Student.Sex.FEMALE)
                //--3-1. 새로운 HashSet 공급하는 Supplier 얻어서,
                //--3-2. collect() 로 새로운 HashSet 얻기
                .collect(Collectors.toCollection(HashSet::new));
        femaleSet.forEach(s -> log.info("{}", s.getName()));

    }
}


//-----------------------------------
@AllArgsConstructor
@Getter
class Student{
    public enum Sex {MALE, FEMALE}
    public enum City {Seoul, Busan}

    private String name;
    private int score;
    private Sex sex;
    private City city;

    Student(String name, int score, Sex sex){
        this.name = name;
        this.score = score;
        this.sex = sex;
    }
}
