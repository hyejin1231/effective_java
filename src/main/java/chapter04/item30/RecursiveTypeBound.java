package chapter04.item30;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * item30. 이왕이면 제네릭 메서드로 만들라.
 * 재귀적 한정 타입을 이용해 상호 비교할 수 있음을 표현
 */
public class RecursiveTypeBound
{
	// 재귀적 타입 한정을 사용해 컬렉션에서 최대값을 반환한다.
	public static <E extends Comparable<E>> E max(Collection<E> collection)
	{
		if (collection.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		E result = null;
		for (E e : collection)
		{
			if (result == null || e.compareTo(result) > 0)
			{
				result = Objects.requireNonNull(e);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		List<String> argList = List.of("hyejin", "park");
		System.out.println("max(argList) = " + max(argList));
	}
}
