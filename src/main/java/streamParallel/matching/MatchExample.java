package streamParallel.matching;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
// 최종 처리 단계에서, 요소들이 특정 조건에 만족하는지 조사하는 maching 메소드.
public class MatchExample {
    public static void main(String[] args) {
        int[] intArr = {2, 4, 6};

        // allMatch() : 모든 요소들이 매개값의 predicate 조건을 만족하는지?
        boolean result = Arrays.stream(intArr)
                .allMatch(a -> a%2 == 0);
        log.info("모두 2의 배수인가? : " + result);

        // anyMatch() : 최소 한 개 이상의 요소가 predicate 조건을 만족하는지?
        result = Arrays.stream(intArr)
                .anyMatch(a -> a%3 == 0);
        log.info("하나라도 3의 배수가 있는가? : " + result);

        // noneMatch() : 모든 요소가 predicate 조건을 만족하지 않는가?
        result = Arrays.stream(intArr)
                .noneMatch(a -> a%3 == 0);
        log.info("3의 배수가 없는가? : " + result);
    }
}
