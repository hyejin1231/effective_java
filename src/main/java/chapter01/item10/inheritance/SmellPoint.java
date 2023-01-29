package chapter01.item10.inheritance;

import chapter01.item10.Point;

/**
 * item10. equals는 기본 규약을 지켜 재정의하라.
 * 완벽공략 - StackOverflowError
 */
public class SmellPoint extends Point
{
	private String smell;
	public SmellPoint(int x, int y, String smell)
	{
		super(x, y);
		this.smell = smell;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Point)) {
			return false;
		}
		
		if (!(obj instanceof SmellPoint)) {
			return obj.equals(this);
		}
		
		return super.equals(obj) && ((SmellPoint) obj).smell == smell;
		
	}
}
