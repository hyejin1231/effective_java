package chapter01.item10.composition;

import java.util.Objects;

import chapter01.item10.Color;
import chapter01.item10.Point;

/**
 * item10. equals는 일반 규약을 지켜 재정의하라.
 */
// equals 규약을 지키면서 값 추가하기 -> 상속 대신 컴포지션을 사용하라!
public class ColorPoint
{
	private final Point point;
	
	private final Color color;
	
	public ColorPoint(int x, int y,  Color color)
	{
		this.point = new Point(x, y);
		this.color = Objects.requireNonNull(color);
	}
	
	// colorPoint의 Point 뷰를 반환한다.
	public Point asPoint()
	{
		return point;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof ColorPoint)) {
			return false;
		}
		
		ColorPoint cp = (ColorPoint) obj;
		return cp.point.equals(point) && cp.color.equals(color);
	}
	
	@Override
	public int hashCode()
	{
		return 31 * point.hashCode() + color.hashCode();
	}
}
