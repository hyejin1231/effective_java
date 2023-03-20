package chapter04.item29.technqiue1;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/**
 * item29. 이왕이면 제네릭 타입으로 만들라.
 * E[]를 이용한 제네릭 스택
 */
public class Stack<E>
{
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACTIY = 16;
	
	// 배열을 사용한 코드를 제네릭으로 만드는 방법 1
	// 배열 elements는 push(E) 로 넘어온 E 인스턴스만 담는다.
	// 따라서 타입 안정성을 보장하지만,
	// 이 배열의 런타임 타입은 E[]가 아닌 Object[] 다!
	// -> 이 방법의 유일한 단점은 Heap 오염이 발생할 수 있다는 점이다.
	@SuppressWarnings("unchecked")
	public Stack()
	{
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACTIY];
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
		
		E result = elements[--size];
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
		Stack<String> stack = new Stack<>();
		for (String arg : List.of("a", "b", "c"))
		{
			stack.push(arg);
		}
		while (!stack.isEmpty())
		{
			System.out.println(stack.pop().toUpperCase());
		}
	}
}
