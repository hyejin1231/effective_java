package chapter02.item13;

import java.security.Signature;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * item13. clone 재정의는 주의해서 진행하라.
 * 가변 객체 clone 정의하는 방법 - shallow copy
 */
public class Stack  implements Cloneable{
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        Object result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Stack clone()  {
        try {
            Stack result = (Stack) super.clone();
            // elements.clone()을 하지않으면 stack과 copy가 동일한 배열을 사용하게 된다!!
            // 근데 배열은 여전히 동일한 인스턴스를 보고 있다.
            // stack -> elementS[0, 1]
            // copy -> elementC[0,1]
            // elementS[0] == elementC[0]
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    // 원소를 위한 공간을 적어도 하나 이상 확보한다.
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        Object[] values = new Object[2];
        values[0] = new PhoneNumber(123, 456, 7890);
        values[1] = new PhoneNumber(321, 765, 4321);

        Stack stack = new Stack();
        for (Object arg : values) {
            stack.push(arg);
        }

        Stack copy = stack.clone();

        System.out.println("pop from stack");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
        System.out.println();

        System.out.println("pop from copy");
        while (!copy.isEmpty()) {
            System.out.println(copy.pop() + " ");
        }

        System.out.println();
        System.out.println("stack.elements[0] == copy.elements[0] = " + (stack.elements[0] == copy.elements[0]));
    }
}
