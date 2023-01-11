package chapter01.item05.singleton;

import java.util.List;

import chapter01.item05.DefaultDictionary;
import chapter01.item05.Dictionary;

/**
 * item05. 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라.
 * 자원을 직접 명시한 코드 (싱글톤 방식)
 * -> 유연성, 재사용성이 떨어지고, 테스트하기 힘들다.
 */
public class SpellChecker
{
	private final Dictionary dictionary = new DefaultDictionary();
	
	private SpellChecker()
	{
	
	}
	
	public static final SpellChecker INSTANCE = new SpellChecker();
	
	public boolean isValid(String word)
	{
		return dictionary.contains(word);
	}
	
	public List<String> suggestions(String typo)
	{
		return dictionary.closeWordsTo(typo);
	}
}
