package streamParallel.optionalClass;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Slf4j
public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // 예외 발생(NoSuchElementException)
//        double avg = list.stream()
//                .mapToInt(Integer :: intValue)
//                .average()
//                .getAsDouble();

        //-- 방법 1.
        // isPresent() 로 값이 저장되어있는지 여부 확인 후,
        // true, false 로 분기하여 처리
        OptionalDouble optional = list.stream()
                .mapToInt(Integer :: intValue)
                .average();
        if (optional.isPresent()){
            log.info("방법 1_평균 : " + optional.getAsDouble());
        } else {
            log.info("방법 1_평균 : 0.0");
        }

        //-- 방법 2.
        // orElse() 로 값이 저장되어있지 않을 경우 디폴트 값 지정
        double avg = list.stream()
                .mapToInt(Integer :: intValue)
                .average()
                .orElse(0.0);
        log.info("방법 2_평균 : " + avg);

        //-- 방법 3.
        // ifPresent() 로 값이 저장되어 있을 경우에만 Consumer 처리
        list.stream()
                .mapToInt(Integer :: intValue)
                .average()
                .ifPresent(a -> log.info("방법 3_평균 : " + a));
    }
}
