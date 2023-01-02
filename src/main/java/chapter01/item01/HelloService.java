package chapter01.item01;

public interface HelloService
{
	String hello();
	
	// Java 8 이후에는 static 메서드 선언 가능
	static HelloService of(String lang)
	{
		if (lang.equals("ko")) {
			return new KoreanHelloService();
		}else {
			return new EnglishHelloService();
		}
	}
}
