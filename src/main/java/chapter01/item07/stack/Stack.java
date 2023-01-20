package chapter01.item07.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * item07. 다 쓴 객체의 참조를 해제하라.
 */
public class Stack
{
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(Object e)
	{
		ensureCapacity();
		elements[size++] = e;
	}
	
	// 메모리 누수가 존재하는 코드
//	public Object pop()
//	{
//		if (size == 0) {
//			throw new EmptyStackException();
//		}
//		return elements[--size];
//	}
	
	/**
	 * 원소를 위한 공간을 적어도 하나 이상 확보한다.
	 * 배열 크기를 늘려야 할 때마다 대략 2배씩 늘린다.
	 */
	private void ensureCapacity()
	{
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	
	// 메모리 누수 없이 제대로 구현한 pop 메서드
	public Object pop()
	{
		if (size == 0) {
			throw new EmptyStackException();
		}
		Object result = elements[--size];
		elements[size] = null; // 방법1) 다 쓴 참조 해제 -> 바람직한 방법은 아니다 -> 객체 참조를 null 처리하는 일은 예외적이어야 한다.
		return result;
	}
	
	public static void main(String[] args)
	{
		Stack stack = new Stack();
		for (String arg : args)
		{
			stack.push(arg);
		}
		
		while (true)
		{
			System.out.println("stack.pop() = " + stack.pop());
		}
	}
}
