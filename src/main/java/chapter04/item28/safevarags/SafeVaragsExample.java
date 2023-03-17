package chapter04.item28.safevarags;

import java.util.List;
import java.util.Objects;

/**
 * item28. 배열보다는 리스트를 사용하라.
 * 완벽공략 - @SafeVarargs
 */
public class SafeVaragsExample
{
	static void notSafe(List<String>... stringLists)
	{
 		Object[] array = stringLists; // List<String>... => List[], 그리고 배열은 공변이니까.
		List<Integer> tmpList = List.of(42);
		array[0] = tmpList;
		String s = stringLists[0].get(0); // ClassCastException RuntimeException 발생
	}
	
	@SafeVarargs // 가변 인자에 대한 해당 오염에 대한 경고를 숨길 수 있다.
	static <T> void safe(T... values)
	{
		for (T value : values)
		{
			System.out.println("value = " + value);
		}
	}
	
	public static void main(String[] args)
	{
		SafeVaragsExample.safe("a", "b", "c");
		SafeVaragsExample.notSafe(List.of("a", "b","c"));
	}
}
