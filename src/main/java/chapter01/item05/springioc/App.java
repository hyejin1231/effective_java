package chapter01.item05.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * item05.자원을 직접 명시하지 말고 의존 객체 주입을 사용하라.
 * 완벽공략 - 스프링 IOC
 */
public class App
{
	public static void main(String[] args)
	{
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		SpellChecker spellChecker = applicationContext.getBean(SpellChecker.class); // 싱글톤
		spellChecker.isValid("test");
		
	}
}
