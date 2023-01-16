package chapter01.item05.springioc;

import java.util.List;

import chapter01.item05.Dictionary;

/**
 * item05.자원을 직접 명시하지 말고 의존 객체 주입을 사용하라.
 * 완벽공략 - 스프링 IOC
 */
public class SpringDictionary implements Dictionary
{
	@Override
	public boolean contains(String word)
	{
		System.out.println("contains.word = " + word);
		return false;
	}
	
	@Override
	public List<String> closeWordsTo(String typo)
	{
		return null;
	}
}
