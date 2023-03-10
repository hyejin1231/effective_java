package chapter04.item26.terms;

import java.util.ArrayList;
import java.util.List;

/**
 * item26. 로 타입은 사용하지 말라.
 */
public class GenericBasic {
    public static void main(String[] args) {
        // Generic 사용하기 전
        // 아무런 타입이나 넣을 수 있어서 안정성이 깨진다.
        // 어떤 타입을 넣어야하는지 넣기전까지 모름
//        List numbers = new ArrayList();
//        numbers.add(10);
//        numbers.add("whiteShip");
//
//        for (Object number : numbers) {
//            System.out.println("number = " + (Integer)number); // error!
//        }

        // Generic 등장 이후
        // 안정성이 생긴다.
        // 타입 선언시 알 수 있어서 표현력이 좋다.
        List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(10);
//        numbers2.add("whiteShip"); // compile error 발생

        // 형변환도 필요 없음
        for (Integer integer : numbers2) {
            System.out.println("integer = " + integer);
        }
    }
}
