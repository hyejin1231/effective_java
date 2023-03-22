package chapter04.item31;

import chapter04.item26.terms.Box;
import chapter04.item31.example.IntegerBox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * item31. 한정적 와일드카드를 사용해 API의 유연성을 높이라.
 */
public class RecursiveTypeBound { // 와일드카드 타입 한정을 이용해 상호 비교할 수 있음을 표현 

    // 컬렉션에서 최대값을 반환하는 메서드 
    public static <E extends Comparable<? super E>> E max(List< ? extends E> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("collection is empty");
        }

        E result = null;

        for (E e : list) {
            if (result == null || e.compareTo(result) > 0) {
                result = e;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<IntegerBox> list = new ArrayList<>();
        list.add(new IntegerBox(1, "hyejin"));
        list.add(new IntegerBox(2, "park"));
        System.out.println("list = " + max(list));
    }
    
}
