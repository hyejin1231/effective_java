package chapter01.item05.factorymethod;

import chapter01.item05.DefaultDictionary;
import chapter01.item05.Dictionary;

/**
 * item05. 자원을 직접 명시하지 말고 의존객체 주입을 사용하라.
 * 완벽공략 - 팩터리 메서드 패턴
 */
public class DefaultDictionaryFactory implements DictionaryFactory
{
	
	@Override
	public Dictionary dictionary()
	{
		return new DefaultDictionary();
	}
}
