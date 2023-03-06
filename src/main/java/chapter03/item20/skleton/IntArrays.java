package chapter03.item20.skleton;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * item20. 추상클래스보다는 인터페이스를 우선하라.
 * 골격 구현을 사용해 완성한 구체 클래스
 */
public class IntArrays
{
	static List<Integer> initArrayList(int[] a)
	{
		Objects.requireNonNull(a);
		
		return new AbstractList<>()
		{
			@Override
			public Integer get(int index)
			{
				return a[index];
			}
			
			@Override
			public Integer set(int index, Integer element)
			{
				int oldVal = a[index];
				a[index] = element;
				return oldVal;
			}
			
			@Override
			public int size()
			{
				return a.length;
			}
		};
	}
	
	public static void main(String[] args)
	{
		int[] a = new int[10];
		for (int i = 0; i< a.length; i++)
		{
			a[i] = i;
		}
		
		List<Integer> list = new ArrayList<>();
		Collections.shuffle(list);
		System.out.println("list = " + list);
	}
}
