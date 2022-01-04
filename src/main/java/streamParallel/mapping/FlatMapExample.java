package streamParallel.mapping;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
// 매핑은 중간처리 기능으로, 스트림의 요소를 다른 요소로 대체하는 작업.
public class FlatMapExample {
    public static void main(String... args){

        // flatMapXXX() 메소드는 요소를 대체하는 복수 개의 요소들로 구성된 새로운 스트림 리턴.
        List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");
        inputList1.stream()
                .flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(log::info);

        log.info("================================");

        List<String> inputList2 = Arrays.asList("10, 20, 30", "40, 50, 60");
        inputList2.stream()
                .flatMapToInt(data -> {
                    String[] strArr = data.split(",");
                    int[] intArr = new int[strArr.length];
                    for(int i=0; i<strArr.length; i++){
                        intArr[i] = Integer.parseInt(strArr[i].trim());
                    }
                    return Arrays.stream(intArr);
                })
                .forEach(number -> log.info("{}", number));
    }
}
