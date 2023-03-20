package chapter04.item30._01_before;

import java.util.function.Function;

/**
 * item30. 이왕이면 제네릭 메서드로 만들라.
 * 제네릭 싱글톤 팩터리 패턴
 */
public class GenericSingletonFactory
{
	public static Function<String, String> stringIndentityFunction()
	{
		return (t) -> t;
	}
	
	public static Function<Number, Number> integerIdentityFunction()
	{
		return (t) -> t;
	}
	
	
	public static void main(String[] args)
	{
		String[] strings = { "삼베", "대마", "나일론" };
		Function<String, String> sameString = stringIndentityFunction();
		for (String string : strings)
		{
			System.out.println("sameString = " + sameString.apply(string));
		}
		
		Number[] numbers = { 1, 2.0, 3L };
		Function<Number, Number> sameNumber = integerIdentityFunction();
		for (Number number : numbers)
		{
			System.out.println("sameNumber = " + sameNumber.apply(number));
		}
	}
}
