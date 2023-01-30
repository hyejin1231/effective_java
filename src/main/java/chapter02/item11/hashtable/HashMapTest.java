package chapter02.item11.hashtable;

import java.util.Map;
import java.util.WeakHashMap;

import chapter02.item11.hashcode.PhoneNumber;

/**
 * item11. equals를 재정의하려거든 hashcode도 재정의하라.
 */
public class HashMapTest
{
	public static void main(String[] args)
	{
		Map<PhoneNumber, String> map = new WeakHashMap<>();
		PhoneNumber number1 = new PhoneNumber(123, 456, 7890);
		PhoneNumber number2 = new PhoneNumber(123, 456, 7890);
		PhoneNumber number3 = new PhoneNumber(456, 789, 1111);
		
		// 같은 인스턴스인데 다른 hashcode
		System.out.println("number1.equals(number2) = " + number1.equals(number2));
		System.out.println("number1.hashCode() = " + number1.hashCode());
		System.out.println("number2.hashCode() = " + number2.hashCode());
		
		// 다른 인스턴스인데 같은 hascode를 쓴다면 ?
		System.out.println("number1.equals(number3) = " + number1.equals(number3));
		System.out.println("number1.hashCode() = " + number1.hashCode());
		System.out.println("number3.hashCode() = " + number3.hashCode());
		
		map.put(number1, "hyejin");
		map.put(number2, "user");
		
		String s = map.get(number2);
		System.out.println("s = " + s);
		
		String s1 = map.get(new PhoneNumber(123, 456, 7890));
		System.out.println("s1 = " + s1); // 아무것도 안나옴
	}
}
