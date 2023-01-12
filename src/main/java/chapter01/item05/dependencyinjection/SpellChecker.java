package chapter01.item05.dependencyinjection;

import java.util.List;
import java.util.function.Supplier;

import chapter01.item05.Dictionary;

/**
 * item05. 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라.
 * 사용하는 자원에 따라 동작이 달라지는 클래스일 때 사용
 * 의존성 주입 코드
 * -> Dictionary가 변경된다 하더라도 모든 코드 재사용 가능
 */
public class SpellChecker
{
	private final Dictionary dictionary;
	
	// 인스턴스를 생성할 때 필요한 자원을 넘겨주는 방식
	public SpellChecker(Supplier<? extends Dictionary> factorySupplier) // Supplier<T>가 팩터리를 표현한 완벽한 예
	{
		this.dictionary = factorySupplier.get();
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
