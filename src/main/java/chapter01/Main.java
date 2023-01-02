package chapter01;

import java.util.Optional;
import java.util.ServiceLoader;

import chapter01.item01.HelloService;
import chapter01.item01.HelloServiceFactory;
import chapter01.item01.Settings;

public class Main
{
	public static void main(String[] args)
	{
		
		// item01. 장점 2
		Settings settings = Settings.newInstance();
		Settings settings2 = Settings.newInstance();
		
		System.out.println("settings = " + settings);
		System.out.println("settings2 = " + settings2);
		
		// item01. 장점 3,4
		HelloService ko = HelloServiceFactory.of("ko");
		HelloService eng = HelloService.of("eng");
		
		System.out.println("ko = " + ko.hello());
		System.out.println("eng = " + eng.hello());
		
		// item01. 장점 5
		// 정적 팩터리 메서들르 작성하는 시점에는 반환할 객체의 클래ㅐ스가 존재하지 않아도 된다.
		// ex). JDBC 어떤 데이터베이스를 사용할 지 모르는데도 사용 가능
		ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
		Optional<HelloService> helloServiceOptional = loader.findFirst();
		helloServiceOptional.ifPresent(h -> {
			System.out.println(h.hello());
		});
		
		
	}
}