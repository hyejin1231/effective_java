package chapter02.item13.treeset;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import chapter02.item13.PhoneNumber;

/**
 * item13. clone 재정의는 주의해서 진행하라.
 * 완벽공략 - TreeSet
 * : 앨리먼트를 추가한 순서는 중요하지 않다.
 *   앨리먼트가 지닌 자연적인 순서(natural order)에 따라 정렬한다.
 */
public class TreeSetExample
{
	public static void main(String[] args)
	{
		TreeSet<Integer> numbers = new TreeSet<>();
		numbers.add(10);
		numbers.add(4);
		numbers.add(6);
		
		for (Integer number : numbers)
		{
			System.out.println("number = " + number);
		}
		
		TreeSet<PhoneNumber> phoneNumbers = new TreeSet<>(Comparator.comparingInt(PhoneNumber::hashCode));
		Set<PhoneNumber> phoneNumberSet = Collections.synchronizedSet(phoneNumbers); // 스레드 안전하기 위해서
		phoneNumbers.add(new PhoneNumber(123, 456,780));
		phoneNumbers.add(new PhoneNumber(123, 456,7800));
		phoneNumbers.add(new PhoneNumber(123, 456,789));
		
		for (PhoneNumber phoneNumber : phoneNumbers)
		{
			System.out.println("phoneNumber = " + phoneNumber); // Comparable을 구현하지 않아서 Error 발생 !
		}
	}
}
