package chapter03.item21.failfast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * item21. 인터페이스는 구현하는 쪽을 생각해 설계하라.
 * 완벽공략 - ConcurrentModificationException
 */
public class FailFast
{
	public static void main(String[] args)
	{
		// numbers와 numbers2는 다르다.
		// List.of로 만든건 수정 불가능 (수정 불가능 컬렉션)
		List<Integer> numbers = List.of(1, 2, 3, 4, 5);
		
		// iterator로 콜렉션을 순회하면서 Collection remove를 하면 error 발생 ! -> UnSupportedOperation
//		for (Integer number : numbers)
//		{
//			if (number == 3) {
//				numbers.remove(number);
//			}
//		}
		
		List<Integer> numbers2 = new ArrayList<>(); // 변경 가능
		numbers2.add(1);
		numbers2.add(2);
		numbers2.add(3);
		numbers2.add(4);
		numbers2.add(5);
		
		// 싱글 스레드에서 iterator가 순회하고 있는데 컬렉션에 변화가 있다면 ConcurrentModificationException을 발생한다.
//		for (Integer integer : numbers2)
//		{
//			if (integer == 3) {
//				numbers2.remove(integer);
//			}
//		}
		
		// 방법1) iterator remove 사용 -> error 발생 x
		for (Iterator<Integer> iterator = numbers2.iterator(); iterator.hasNext();)
		{
			Integer integer = iterator.next();
			if (integer == 3) {
				iterator.remove(); // iterator가 삭제하도록 해서 iterator가 알도록!
			}
		}
		
		// 방법2) index 사용하기 -> error 발생 x
		for (int i = 0; i< numbers2.size(); i++)
		{
			if (numbers2.get(i) == 3) {
				numbers2.remove(numbers2.get(i));
			}
		}
		
		numbers2.removeIf(number -> number == 3);
		numbers2.forEach(System.out::println);
		
	}
}
