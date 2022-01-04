package streamParallel.sorting;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
// 객체요소에 sorted() 메소드를 사용하려면 반드시 Comparable 를 implements 해야 함.
// 그렇지 않으면 CLassCastException 발생
public class Student implements Comparable<Student>{
    private String name;
    private int score;

    @Override
    public int compareTo(Student o){
        // score < o.score : 음수 리턴
        // score == o.score : 0 리턴
        // score > o.score : 양수 리턴
        return Integer.compare(score, o.score);
    }
}
