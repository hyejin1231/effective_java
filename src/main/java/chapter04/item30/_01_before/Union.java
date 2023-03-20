package chapter04.item30._01_before;

import java.util.HashSet;
import java.util.Set;

/**
 * item30. 이왕이면 제네릭 메서드로 만들라.
 */
public class Union
{
	// 제네릭 사용 전 메서드
	public static Set union(Set s1, Set s2)
	{
		Set result = new HashSet(s1);
		result.addAll(s2);
		return result;
	}
	
	public static void main(String[] args)
	{
		Set guys = Set.of("톰", "닥", "해리");
		Set stooges = Set.of(1, 2, 3);
		Set all = union(guys, stooges);
		
		for (Object o : all)
		{
			System.out.println("o = " + (String) o);
		}
	}
}
