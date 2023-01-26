package chapter01.item10.inheritance;

import chapter01.item10.Color;
import chapter01.item10.Point;

/**
 * item10. equals는 기본 규약을 지켜서 재정의하라.
 */
// Point에 값 컴포넌트(color)를 추가
public class ColorPoint extends Point
{
	private final Color color;
	
	public ColorPoint(int x, int y, Color color)
	{
		super(x, y);
		this.color = color;
	}
	
	// 잘못된 코드 : 대칭성 위배
//	@Override
//	public boolean equals(Object obj)
//	{
//		if (!(obj instanceof ColorPoint)) {
//			return false;
//		}
//
//		return super.equals(obj) && ((ColorPoint) obj).color == color;
//	}
	
	// 잘못된 코드 : 추이성 위배
	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Point)) {
			return false;
		}
		
		// obj가 일반 Point이면 color를 무시하고 비교한다.
		if (!(obj instanceof ColorPoint)) {
			return obj.equals(this);
		}
		
		// obj가 ColorPoint이면 색상까지 비교한다.
		return super.equals(obj) && ((ColorPoint) obj).color == color;
		
	}
	
	public static void main(String[] args)
	{
		// 첫번째 equals는 대칭성을 위배한다.
//		Point point = new Point(1, 2);
//		ColorPoint colorPoint = new ColorPoint(1, 2, Color.RED);
//		System.out.println(point.equals(colorPoint) + " " + colorPoint.equals(point));
		
		// 두번째 equals는 추이성을 위배한다.
		ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
		Point p2 = new Point(1, 2);
		ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
		System.out.printf("%s %s %s%n", p1.equals(p2), p2.equals(p3), p1.equals(p3));
	}
}
