package chapter04.item26.terms;

/**
 * item26. 로 타입은 사용하지 말라.
 */
public class Box<E /*extends Number*/> { // 제네릭 클래스 <E> : 타입 매개변수 extends Number : Number를 상속받은 타입만 가능 (한정적인 타입 매개변수)

    private E item;

    private void add(E e) {
        this.item = e;
    }

    private E get() {
        return this.item;
    }

    public static void main(String[] args) {
        Box<Integer> box = new Box<>(); // <Integer> : 실제 타입 매개변수
        box.add(10);
        System.out.println(box.get() * 100);
        printBox(box);

    }
    private static void printBox(Box<?> box) { // 비한정적 와일드 카드 타입 (아무런 타입이나 대응이 된다.)
        System.out.println("box = " + box.get());
    }
}
