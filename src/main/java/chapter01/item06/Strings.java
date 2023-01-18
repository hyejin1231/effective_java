package chapter01.item06;

/**
 * item06. 불필요한 객체 생성을 피하라.
 * 1) 문자열: 사실상 동일한 객체라서 매번 새로 만들 필요가 없다.
 * new String()을 사용하지 않고 문자열 리터럴을 사용해 기존에 동일한 문자열을 재사용하는 것이 좋다.
 */
public class Strings {
    public static void main(String[] args) {
        String hello = "hello";
        String hello2 = new String("hello"); // 이 방법은 권장하지 않음! -> 메모리를 많이 사용하는 단점
        String hello3 = "hello";

        System.out.println("hello == hello2 = " + (hello == hello2));
        System.out.println("hello == hello3 = " + (hello == hello3));
    }
}
