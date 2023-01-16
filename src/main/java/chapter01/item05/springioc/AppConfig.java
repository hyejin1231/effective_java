package chapter01.item05.springioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chapter01.item05.Dictionary;

/**
 * item05.자원을 직접 명시하지 말고 의존 객체 주입을 사용하라.
 * 완벽공략 - 스프링 IOC
 */
@Configuration
public class AppConfig
{
	@Bean
	public SpellChecker spellChecker(Dictionary dictionary)
	{
		return new SpellChecker(dictionary);
	}
	
	@Bean
	public Dictionary dictionary()
	{
		return new SpringDictionary();
	}
	
}
