package streamParallel.aggregate;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
// 집계(Aggregate)는 최종 처리 기능으로 요소들을 처리해서 카운팅, 합계, 평균/최대/최소값과 같이 하나의 값으로 산출하는 것.
// 대량의 데이터를 가공해서 축소하는 Reduction 이다.
public class AggregateExample {
    public static void main(String[] args) {
        long count = Arrays.stream(new int[]{1,2,3,4,5})
                .filter(n -> n%2 ==0) // 중간처리 : 필터링 -> stream 리턴
                .count(); // ** 최종처리 : 집계(카운팅)
        log.info("2의 배수 개수 : {}", count);

        long sum = Arrays.stream(new int[] {1,2,3,4,5})
                .filter(n -> n%2 ==0)
                .sum();
        log.info("2의 배수의 합 :{}", sum);

        int max = Arrays.stream(new int[] {1,2,3,4,5})
                .filter(n -> n%2 == 0)
                .max()  // min, average 도 있음
                .getAsInt();
        log.info("최대값 : {}", max);
    }

}
