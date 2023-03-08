package chapter03.item23.hierarchy;

/**
 * item23. 태그 달린 클래스보다는 클래스 계층 구조를 활용하라.
 */
public class Square extends Rectangle{
    public Square(double side) {
        super(side, side);
    }
}
