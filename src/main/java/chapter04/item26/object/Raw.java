package chapter04.item26.object;

import java.util.ArrayList;
import java.util.List;

/**
 * item26. 로 타입은 사용하지 말라.
 * List와 List<Object> 의 차이는?
 */
public class Raw {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42)); // 잘못된 값이 들어갈 수 있다!
        String s = strings.get(0); // 컴파일러가 자동으로 형변환 코드를 넣어준다.

//        unsafeAdd2(strings, Integer.valueOf(42)); // List<Object>와 List<String>은 다른것이기 때문에 애초에 에러가 난다.
    }

    // 로 타입은 타입 안정성을 잃었다.
    // 왜냐하면 어떤 List든 일단 받고 잘못된 값이 들어갈 확률이 많기 때문이다.
    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    // List<Object>는
    private static void unsafeAdd2(List<Object> list, Object o) {
        list.add(o);
    }
}
