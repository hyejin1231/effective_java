package chapter01.item01;

/**
 * item01. 생성자 대신 정적 팩터리 메서드를 고려하라.
 * : 반환 타입의 하위 타입 객체를 반환할 수 있고, 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
 * 구체적인 타입을 클라이언트에게 숨길 수 있다.
 */
public class HelloServiceFactory
{
	public static HelloService of(String lang)
	{
		if (lang.equals("ko")) {
			return new KoreanHelloService();
		}else {
			return new EnglishHelloService();
		}
	}

}
