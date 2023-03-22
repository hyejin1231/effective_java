package chapter04.item31;

import java.util.HashSet;
import java.util.Set;

/**
 * item31. 한정적 와일드카드를 사용해 API의 유연성을 높이라.
 */
public class Union {
    // producer
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(3);
        integers.add(5);

        Set<Double> doubles = new HashSet<>();
        doubles.add(2.0);
        doubles.add(4.0);
        doubles.add(6.0);

        Set<Number> numbers = union(integers, doubles);

        System.out.println("numbers = " + numbers);
    }

}

