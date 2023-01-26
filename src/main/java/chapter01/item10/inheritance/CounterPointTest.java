package chapter01.item10.inheritance;

import java.util.Set;

import chapter01.item10.Color;
import chapter01.item10.Point;
import chapter01.item10.composition.ColorPoint;

// CounterPoint를 Point로 사용하는 테스트 프로그램
public class CounterPointTest
{
	// 단위 원 안의 모든 점을 포함하도록 unitCircle을 초기화한다.
	private static final Set<Point> unitCircle = Set.of(
			new Point(1, 0), new Point(0, 1),
			new Point(-1, 0), new Point(0, -1)
	);
	
	public static boolean onUnitCircle(Point p)
	{
		return unitCircle.contains(p);
	}
	
	public static void main(String[] args)
	{
		Point p1 = new Point(1, 0);
//		Point p2 = new CounterPoint(1, 0);
		Point p2 = new ColorPoint(1, 0, Color.RED).asPoint();
		
		System.out.println("onUnitCircle(p1) = " + onUnitCircle(p1)); // true 출력
		
		// true를 출력해야 하지만, Point의 equals가 getClass를 사용해 작성되었다면 false를 출력한다.
		System.out.println("onUnitCircle(p2) = " + onUnitCircle(p2));
	}
	
	
	
}
