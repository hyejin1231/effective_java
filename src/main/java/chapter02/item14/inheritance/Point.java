package chapter02.item14.inheritance;

/**
 * item14. Comparable을 구현할지 고민하라.
 */
public class Point implements Comparable<Point>
{
	final int x, y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	@Override
	public int compareTo(Point o)
	{
		int result = Integer.compare(this.x, o.x);
		if (result == 0) {
			result = Integer.compare(this.y, o.y);
		}
		
		return result;
	}
}
