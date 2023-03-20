package chapter04.item30._02_after;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * item30. 이왕이면 제네릭 메서드로 만들라.
 * 제네릭 싱글톤 팩터리 패턴
 */
public class GenericSingletonFactory
{
	// 제네릭 싱글톤 팩터리 패턴
	private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;
	
	public static <T> UnaryOperator<T> identityFunction()
	{
		return (UnaryOperator<T>) IDENTITY_FN;
	}
	
	public static void main(String[] args)
	{
		String[] strings = { "삼베", "대마", "나일론" };
		UnaryOperator<String> sameString = identityFunction();
		for (String string : strings)
		{
			System.out.println("sameString = " + sameString.apply(string));
		}
		
		Number[] numbers = { 1, 2.0, 3L };
		UnaryOperator<Number> sameNumber = identityFunction();
		for (Number number : numbers)
		{
			System.out.println("sameNumber = " + sameNumber.apply(number));
		}
	}
}
