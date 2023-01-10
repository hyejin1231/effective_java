package chapter01.item03.functionalinterface;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import chapter01.item03.methodreference.Person;

/**
 * 자바가 제공하는 기본 함수형 인터페이스
 */
public class DefaultFunctions
{
	public static void main(String[] args)
	{
		//       <input>, <output>
		Function<Integer, String> intToString = Objects::toString;
		
		// 인자는 없는데 return은 해주는 것
		Supplier<Person> personSupplier = Person::new; // 기본 생성자
		Function<LocalDate, Person> personFunction = Person::new; // localDate를 받는 생성자
		
		// 인자는 있는데 return은 없는 것
		Consumer<Integer> integerConsumer =  System.out::println;
		
		// boolean을 리턴
		Predicate<Integer> integerPredicate;
	}
}
