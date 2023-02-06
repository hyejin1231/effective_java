package chapter02.item14.composition;

/**
 * item14. Comparable을 구현할지 고민하라.
 * : 권장하는 구현 방법
 */
public class NamedPoint implements Comparable<NamedPoint>
{
	private final Point point;
	
	private final String name;
	
	public NamedPoint(Point point, String name)
	{
		this.point = point;
		this.name = name;
	}
	
	public Point getPoint()
	{
		return this.getPoint();
	}
	@Override
	public int compareTo(NamedPoint o)
	{
		int result = this.point.compareTo(o.point);
		if (result == 0) {
			result = this.name.compareTo(o.name);
		}
		return result;
	}
}
