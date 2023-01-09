package chapter01.item03.methodreference;

import java.time.LocalDate;

public class Person
{
	LocalDate birthday;
	
	public Person()
	{
	}
	
	public Person(LocalDate birthday)
	{
		this.birthday = birthday;
	}
	
	public int getAge()
	{
		return LocalDate.now().getYear() - birthday.getYear();
	}
	
	public static int compareByAge(Person a, Person b)
	{
		return a.birthday.compareTo(b.birthday);
	}
}
