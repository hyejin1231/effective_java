package chapter03.item23.hierarchy;

/**
 * item23. 태그 달린 클래스보다는 클래스 계층 구조를 활용하라.
 * 태그 달린 클래스를 클래스 계층 구조로 변환 !
 */
public class Rectangle extends Figure{
    final double length;
    final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}
