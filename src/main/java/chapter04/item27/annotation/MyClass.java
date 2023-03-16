package chapter04.item27.annotation;

import java.util.Arrays;

/**
 * item27. 비검사 경고를 제거하라.
 * 완벽공략 - 애너테이션
 */
@MyAnnotation
public class MyClass
{
	@MyAnnotation
	public static void main(String[] args)
	{
		Arrays.stream(MyClass.class.getAnnotations()).forEach(System.out::println);
	}
}
