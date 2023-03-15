package chapter04.item26.unbounded;

import java.util.HashSet;
import java.util.Set;

/**
 * item26. 로 타입은 사용하지 말라.
 * Set 과 Set<?>의 차이점은?
 * 거의 같지만 안정성의 차이가 있는 것이다!!
 */
public class Numbers {
    static int numElementsInCommon(Set s1, Set s2) { // 역시 Set은 안정성이 깨진다 (아무값이나 넣을 수 있어서)
        int result = 0;
        for (Object o : s1) {
            if (s2.contains(o)) {
                result ++;
            }
        }
        return result;
    }

    // Set<?>으로 선언하면 무엇이든 받을 수 있는 Set 타입이 된다.
    static int numElementsInCommon2(Set<?> s1, Set<?> s2) { // Set<?>는 한종류의 타입만 받을 수 있다.
        int result = 0;
        for (Object o : s1) {
            if (s2.contains(o)) {
                result ++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Set<?> mySet = set;


        System.out.println(Numbers.numElementsInCommon(Set.of(1, 2 ,3), Set.of(1,2)));
        System.out.println(Numbers.numElementsInCommon2(Set.of(1, 2 ,3), Set.of(1,2)));
    }
}
