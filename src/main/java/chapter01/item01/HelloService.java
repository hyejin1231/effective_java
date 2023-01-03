package chapter01.item01;

public interface HelloService
{
	String hello();
	
	static String hi() // 정적 메서드
	{
		prepareMessage();
		return "hi";
	}
	static String hi1() // 정적 메서드
	{
		prepareMessage();
		return "hi";
	}
	static String hi2() // 정적 메서드
	{
		prepareMessage();
		return "hi";
	}
	
	static private void prepareMessage()
	{
		// 자바 9부터 private static 메소드도 추가할 수 있다.
	}
	
	default String bye() // 기본 메서드
	{
		return "bye";
	}
	
	
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
