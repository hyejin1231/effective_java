package chapter02.item13.inheritance;

/**
 * item13. clone 재정의는 주의해서 진해하라.
 * 일반적으로 상속용 클래스에는 Cloneable 인터페이스 사용을 권장하지 않는다.
 * -> 왜냐하면 해당 클래스를 확장하는 프로그래머에게 부담을 주기 때문
 */
public abstract class Shape implements Cloneable { // 지금은 굳이 사용한 경우
    private int area;

    public abstract int getArea();
    
    /**
     * 방법 1) 프로그래머에게 부담을 덜기 위해서는 기본 clone() 구현체를 제공하고,
     * Cloneable 구현 여부를 서브 클래스에서 선택할 수 있도록 한다.
     * 서브 클래스가 구현을 안해도 되도록
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    /**
     * 방법 2) Cloneable 구현을 아예 막는 방법
     * @return
     * @throws CloneNotSupportedException
     */
//    @Override
//    protected final Object clone() throws CloneNotSupportedException {
//        return new CloneNotSupportedException();
//    }
}
