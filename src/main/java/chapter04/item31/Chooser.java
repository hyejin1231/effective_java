package chapter04.item31;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * item31. 한정적 와일드카드를 사용해 API의 유연성을 높이라.
 */
public class Chooser<T> { // T 생성자 매개변수에 와일드 카드 타입 적용
    private final List<T> choiceList;
    private final Random rnd = new Random();

    // producer
    public Chooser(Collection<? extends T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
        Chooser<Number> chooser = new Chooser<>(intList);
        for (int i = 0; i < 10; i++) {
            Number choose = chooser.choose();
            System.out.println("choose = " + choose);
        }
    }
}
