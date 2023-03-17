package chapter04.item28.array_to_list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * item28. 배열보다는 리스트를 사용하라.
 */
public class Chooser_List<T> // 리스트 기반 Chooser
{
	private final List<T> choiceList;
	
	public Chooser_List(Collection<T> choices)
	{
		choiceList = new ArrayList<>(choices);
	}
	
	public T choose()
	{
		Random rnd = ThreadLocalRandom.current();
		return choiceList.get(rnd.nextInt(choiceList.size()));
	}
	
	public static void main(String[] args)
	{
		// 리스트 기반 chooser는 훨씬 더 안전한 코드가 된다.
		List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
		Chooser_List<Integer> chooser = new Chooser_List<>(intList);
		
		for (int i = 0; i < 10; i++)
		{
			Number choice = chooser.choose();
			System.out.println("choice = " + choice);
		}
	}
}
