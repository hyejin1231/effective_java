package chapter04.item30._01_after;

import java.util.HashSet;
import java.util.Set;

/**
 * item30. 이왕이면 제네릭 메서드로 만들라.
 */
public class Union
{
	// 제네릭 사용 전 메서드
	public static <E> Set<E> union(Set<E> s1, Set<E> s2)
	{
		Set<E> result = new HashSet<>(s1);
		result.addAll(s2);
		return result;
	}
	
	public static void main(String[] args)
	{
		Set<String> guys = Set.of("톰", "닥", "해리");
		Set<String> stooges = Set.of("래리", "모에", "컬리");
//		Set<Integer> stooges = Set.of(1, 2, 3);
		Set<String> all = union(guys, stooges); // <Integer> 는 같은 타입을 넣으라고 했기 때문에 error
		
		for (String o : all)
		{
			System.out.println("o = " + o);
		}
	}
}
