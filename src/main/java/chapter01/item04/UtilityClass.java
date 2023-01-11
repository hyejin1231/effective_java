package chapter01.item04;

/**
 * item04. 인스턴스화를 막으려거든 private 생성자를 사용하라.
 * 1) abstract를 추가하라 (추상 클래스로 만들어라) -> 서브 클래스를 만들면 인스턴스를 만들 수 있다..!
 * 2) private 생성자를 바꾸자.
 */
public class UtilityClass {

    /**
     * 이 클래스는 인스턴스를 만들 수 없습니다.
     */
    private UtilityClass() {
        // 내부에서도 생성자를 호출하지 못하도록 하기 위해서는
        // 에러를 던져줌으로써 이 코드는 만나면? 안된다고 얘기해주는 것이다.
        // try-catch로 잡을 필요 없음
        throw new AssertionError();
    }

    public static String hello() {
        return "hello";
    }
}
