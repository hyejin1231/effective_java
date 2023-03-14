package chapter03.item24.annoymousclass;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/**
 * item24. 멤버 클래스는 되도록 staic으로 만들라.
 * 골격 구현을 사용해 완성한 구체 클래스
 */
public class IntArrays
{
	static List<Integer> intArrayAsList(int[] a)
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
		for (int i = 0; i < a.length; i++)
		{
			a[i] = i;
		}
	}
}
