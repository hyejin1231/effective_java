package chapter01.item03.staticfactory;

import java.util.Objects;

public class App
{
	public static void main(String[] args)
	{
		Elvis elvis = Elvis.getInstance();
		elvis.leaveTheBuilding();
		
		System.out.println("Elvis.getInstance() = " + Elvis.getInstance());
		System.out.println("Elvis.getInstance() = " + Elvis.getInstance());
		
		MetaElvis<String> metaElvis1 = MetaElvis.getInstance();
		MetaElvis<Integer> metaElvis2 = MetaElvis.getInstance();
		
		// == 비교는 제니릭 타입이 다르기 때문에 == 는 안된다.
		System.out.println(
				"(Objects.equals(metaElvis1, metaElvis2)) = " + (Objects.equals(metaElvis1, metaElvis2))); // 해시코드가 같고 같은 인스턴스
		
		// private 생성자 + 정적 팩터리 메서드
		// 장점: 정적 팩터리의 메서드 참조를 supplier의 공급자로 상요할수 있다는 점
		Concert concert = new Concert();
		concert.start(Elvis::getInstance);
	}
}
