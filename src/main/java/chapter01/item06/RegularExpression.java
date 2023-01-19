package chapter01.item06;

import java.util.regex.Pattern;

public class RegularExpression
{
	private static final Pattern SPLIT_PATTERN = Pattern.compile(",,,");
	
	public static void main(String[] args)
	{
		long start = System.nanoTime();
		for (int i = 0; i< 10000; i++)
		{
			String name = "hyejin,,,20230119,,,effective java study";
			name.split(",,,"); // 한글자(,) 기준으로 쪼개는 건 미리 Pattern을 만든것이랑 성능 차이가 별로 없다.
//			SPLIT_PATTERN.split(name);
		}
		
		System.out.println(System.nanoTime() - start);
	}
}
