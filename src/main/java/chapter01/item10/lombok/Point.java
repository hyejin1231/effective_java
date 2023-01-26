package chapter01.item10.lombok;

import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * lombok 사용
 */
@EqualsAndHashCode
@ToString
public class Point
{
	private final int x;
	
	private final int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	// IDE 사용 -> 단점: 코드가 지저분해진다, 필드가 늘어나면 다시 만들어야 한다.
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Point point = (Point) o;
		return x == point.x && y == point.y;
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(x, y);
	}
}
