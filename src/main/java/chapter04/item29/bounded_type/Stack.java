package chapter04.item29.bounded_type;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/**
 * item29. 이왕이면 제네릭 타입으로 만들라.
 * 완벽공략 - 한정적 타입 매개변수
 */
public class Stack<E extends Number>
{
	private Number[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACTIY = 16;
	
	public Stack()
	{
		elements = new Number[DEFAULT_INITIAL_CAPACTIY];
	}
	
	public void push(E e)
	{
		ensureCapacity();
		elements[size++] = e;
	}
	
	public E pop()
	{
		if (size == 0) {
			throw new EmptyStackException();
		}
		
		@SuppressWarnings("unchecked")
		E result = (E) elements[--size];
		elements[size] = null;
		return result;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	
	private void ensureCapacity()
	{
		if (elements.length == 0) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	
	public static void main(String[] args)
	{
		Stack<Integer> stack = new Stack<>();
		for (Integer arg : List.of(1, 2, 3))
		{
			stack.push(arg);
		}
		while (!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
	}
}
