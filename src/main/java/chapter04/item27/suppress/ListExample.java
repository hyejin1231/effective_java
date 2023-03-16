package chapter04.item27.suppress;

import java.util.Arrays;

/**
 * item27. 비검사 경고를 제거하라.
 * @SuppressWarning : 경고를 제거할 수 없지만 안전하다고 확신할 때 사용
 */
public class ListExample
{
	private int size;
	
	Object[] elements;
	
	public <T> T[] toArray(T[] a)
	{
		if (a.length < size) {
			/**
			 * 어노테이션이 안전한 이유도 주석으로 써주면 좋다.
			 */
			@SuppressWarnings("unchecked") // 가능한한 좁은 범위로 어노테이션 붙이기
			T[] result = (T[]) Arrays.copyOf(elements, size, a.getClass());
			return result;
		}
		System.arraycopy(elements, 0, a, 0, size);
		
		if (a.length > size) {
			a[size] = null;
		}
		return a;
	}
	
	public static void main(String[] args)
	{
	
	}
}
