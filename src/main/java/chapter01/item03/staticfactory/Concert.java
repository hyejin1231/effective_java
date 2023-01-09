package chapter01.item03.staticfactory;

import java.util.function.Supplier;

/**
 * item03. private 생성자나 열거 타입으로 싱글톤임을 보증하라.
 * 2) private 생성자 + public static (정적 팩터리 메서드)
 * 장점 : 정적 팩터리의 메서드 참조를 공급자로 사용할 수 있다는 점이다.
 */
public class Concert
{
	public void start(Supplier<Singer> singerSupplier)
	{
		Singer singer = singerSupplier.get();
		singer.sing();
	}
}
