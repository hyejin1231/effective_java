package chapter04.item31;

import java.util.Arrays;
import java.util.List;

/**
 * item31. 한정적 와일드 카드를 사용해 API의 유연성을 높이라.
 */
public class Swap {
//    public static <E> void swap(List<E> list, int i, int j) {
        public static void swap(List<?> list, int i, int j) {
//        list.set(i, list.set(j, list.get(i)));
        swapHelper(list, i , j);
    }

    // 와일드카드 타입을 실제 타입으로 바꿔주는 Private 도우미 메서드
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static void main(String[] args) {
        List<String> argList = Arrays.asList(args);
        swap(argList, 0, argList.size() - 1);
        System.out.println("argList = " + argList);
    }
}
