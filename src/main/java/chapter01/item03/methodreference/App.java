package chapter01.item03.methodreference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class App
{
	public static void main(String[] args)
	{
		List<Person> people = new ArrayList<>();
		people.add(new Person(LocalDate.of(1998, 11, 11)));
		people.add(new Person(LocalDate.of(2000, 1, 1)));
		people.add(new Person(LocalDate.of(1999, 03, 02)));
		
		// 익명 내부 클래스
		people.sort(new Comparator<Person>()
		{
			// Comparator 인터페이스를 구현한 구현체
			@Override
			public int compare(Person o1, Person o2)
			{
				return o1.birthday.compareTo(o2.birthday);
			}
		});
		
		// lambda
		people.sort((p1, p2) -> Person.compareByAge(p1,p2));
		
		// static 메소드 참조
		people.sort(Person::compareByAge);
		
		// 생성자 메소드 참조
		ArrayList<LocalDate> dates = new ArrayList<>();
		dates.add(LocalDate.of(2000, 1, 1));
		dates.add(LocalDate.of(2001, 2, 2));
		dates.add(LocalDate.of(2002, 3, 4));
		
		List<Person> personList = dates.stream().map(Person::new).collect(Collectors.toList());
		
		Callable<Person> personCallable = Person::new;
		Supplier<Person> personSupplier = Person::new;
		Function<LocalDate, Person> personFunction = Person::new;
		
	}
}
