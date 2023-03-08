package chapter03.item23.taggedclass;

/**
 * item23. 태그 달린 클래스보다는 클래스 계층 구조를 활용하라.
 * 태그 달린 클래스 - 클래스 계층 구조보다 훨씬 나쁘다..!!!!
 * 쓸데없는 코드가 많고 가독성이 나쁘며 메모리를 많이 사용한다.
 */
public class Figure {
    enum Shape {RECTANGLE, CIRCLE, SQUARE}

    // 태그 필드 -  현재 모양을 나타낸다.
    final Shape shape;

    // 다음 필드들은 모양이 사각형일 때만 쓰인다.
    double length;
    double width;

    // 다음 필드는 모양이 원일때만 사용한다.
    double radius;

    // 원용 생성자
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // 사각형용 생성자
    Figure(double length, double width) {
        if (this.length == this.length) {
            shape = Shape.SQUARE;
        }else {
            shape = Shape.RECTANGLE;
        }
        this.length = length;
        this.width = width;
    }


    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}
