package chapter04.item31;

import java.util.*;

/**
 * item30. 한정적 와일드 카드를 사용해 API 유연성을 높이라.
 */
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 와일드카드 타입을 사용하지 않은 pushAll 메서드 -> 결함이 있다!
//    public void pushAll(Iterable<E> src) {
//        for (E e : src) {
//            push(e);
//        }
//    }

    // 생산자(producer) 매개변수에 와일드카드 타입 적용
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    // 와일드카드 타입을 사용하지 않은 popAll 메서드 -> 결함이 있다!
//    public void popAll(Collection<E> dst) {
//        while (!isEmpty()) {
//            dst.add(pop());
//        }
//    }

    // 소비자(consumer) 매개변수에 와일드카드 타입 적용
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }


    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
        numberStack.pushAll(integers);

        Iterable<Double> doubles = Arrays.asList(3.0, 1.0);
        numberStack.pushAll(doubles);

        Collection<Object> objects = new ArrayList<>();
        numberStack.popAll(objects);

        System.out.println("objects = " + objects);
    }
}
