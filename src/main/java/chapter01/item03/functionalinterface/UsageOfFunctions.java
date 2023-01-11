package chapter01.item03.functionalinterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * item03. private 생성자 또는 열거 타입으로 싱글톤임을 보증하라.
 * 완벽공략 - 함수형 인터페이스
 */
public class UsageOfFunctions
{
	public static void main(String[] args)
	{
		List<LocalDate> dates = new ArrayList<>();
		dates.add(LocalDate.of(1999, 10, 10));
		dates.add(LocalDate.of(2000, 02, 02));
		dates.add(LocalDate.of(2022, 5, 5));
		
		Predicate<LocalDate> localDatePredicate = d -> d.isBefore(LocalDate.of(2000, 1, 1));
		Function<LocalDate, Integer> getYear = LocalDate::getYear;
		
		List<Integer> before2000 = dates.stream()
				.filter(localDatePredicate)
				.map(getYear)
				.collect(Collectors.toList());
		
		
		MyFunction lambdaMyfunction = (i) -> String.valueOf(i); // lambda
		MyFunction myFunction = String::valueOf;
	}
}
