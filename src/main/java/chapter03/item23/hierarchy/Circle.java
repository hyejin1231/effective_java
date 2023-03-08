package chapter03.item23.hierarchy;

/**
 * item23. 태그 달린 클래스보다는 클래스 계층 구조를 활용하라.
 * 태그 달린 클래스를 계층 구조로 변환!!
 */
public class Circle extends Figure{

    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}
