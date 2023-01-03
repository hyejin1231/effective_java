package chapter01.item01;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main
{
	public static void main(String[] args)
	{
		
		// item01. 장점 2
		Settings settings = Settings.getInstance();
		Settings settings2 = Settings.getInstance();
		
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
		
		// item01 완벽 공략. 열거타입
		// 질문1) 특정 enum 타입이 가질 수 있는 모든 값을 순회하며 출력하라
		System.out.println("질문1) 특정 enum 타입이 가질 수 있는 모든 값을 순회하며 출력하라");
		Arrays.stream(OrderStatus.values()).forEach(System.out::println);
		
		// enum의 값은 == 연산자로 동일성을 비교할 수 있는가?
		// == 연산자 사용을 권장한다. (NPE 방지 위해서, equals()는 Enum이 null이면 NPE 발생!
		// 왜냐하면 jvm 내에서 enum은 하나의 인스턴스만 생성하기 때문에
		
		// 과제) enum을 key로 사용하는 Map을 정의하세요. 또는 enum을 담고 있는 Set을 만들어 보세요. -> EnumSet, EnumMap 사용
		// map, set보다 훨씬 효율적이다.
		EnumMap<OrderStatus, String> enumMap = new EnumMap<OrderStatus, String>(OrderStatus.class);
		
		EnumSet<OrderStatus> enumSet = EnumSet.allOf(OrderStatus.class);
		
		// item02 완벽 공략. flyWeight pattern
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 나무 색을 입력하세요 : ");
		for (int i = 0; i< 10; i++)
		{
			String input = scanner.nextLine();
			Tree tree = TreeFactory.getTree(input);
			
			tree.setX((int) (Math.random() * 100));
			tree.setY((int) (Math.random() * 100));
			
			tree.install();
		}
		
		
	}
}