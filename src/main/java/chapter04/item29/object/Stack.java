package chapter04.item29.object;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/**
 * item29. 이왕이면 제네릭 타입으로 만들라.
 * Object를 이용한 제네릭 스택
 */
public class Stack
{
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public Stack()
	{
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(Object e)
	{
		ensureCapacity();
	}
	
	public Object pop()
	{
		if (size == 0) {
			throw new EmptyStackException();
		}
		
		Object result = elements[--size];
		elements[size] = null;
		return result;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	private void ensureCapacity()
	{
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	
	public static void main(String[] args)
	{
		Stack stack = new Stack();
		for (String arg: List.of("a", "b", "c"))
		{
			stack.push(arg);
		}
		while (!stack.isEmpty())
		{
			System.out.println(((String) stack.pop()).toUpperCase());
		}
	}
}
