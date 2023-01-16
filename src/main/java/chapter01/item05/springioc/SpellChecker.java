package chapter01.item05.springioc;

import java.util.List;

import chapter01.item05.Dictionary;

/**
 * item05.자원을 직접 명시하지 말고 의존 객체 주입을 사용하라.
 * 완벽공략 - 스프링 IOC
 * 스프링의 코드를 노출하지 않으면서도 스프링이 제공하는 기능을 사용할 수 있도록! non-invasive
 */
public class SpellChecker
{
	private Dictionary dictionary;
	
	public SpellChecker(Dictionary dictionary)
	{
		this.dictionary = dictionary;
	}
	
	public boolean isValid(String word)
	{
		return dictionary.contains(word);
	}
	
	public List<String> suggestions(String typo)
	{
		return dictionary.closeWordsTo(typo);
	}
}
