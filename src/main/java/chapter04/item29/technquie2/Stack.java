package chapter04.item29.technquie2;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/**
 * item29. 이왕이면 제네릭 타입으로 만들라.
 * Object[]를 이용한 제네릭 Stack
 */
public class Stack<E>
{
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACTIY = 16;
	
	public Stack()
	{
		elements = new Object[DEFAULT_INITIAL_CAPACTIY];
	}
	
	public void push(E e)
	{
		ensureCapacity();
		elements[size++] = e;
	}
	
	// 배열을 사용한 코드를 제네릭으로 만드는 방법 2
	// 비검사 경고를 적절히 숨긴다.
	public E pop()
	{
		if (size == 0) {
			throw new EmptyStackException();
		}

		// push에서 E 타입만 허용하므로 이 형변환은 안전하다.
		@SuppressWarnings("unchecked")
		E result = (E) elements[--size];
		elements[size] = null; // 다 쓴 참조 해제
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
		Stack<String> stack = new Stack<>();
		for (String arg : List.of("a", "b", "c"))
		{
			stack.push(arg);
		}
		while (stack.isEmpty())
		{
			System.out.println(stack.pop().toUpperCase());
		}
	}
}
