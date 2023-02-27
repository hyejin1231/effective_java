package chapter03.item16.point.method;

/**
 * item16. public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라.
 * -> 좀 더 유연해지고, 캡슐화할 수 있다.
 * 근데 package-private 클래스 또는 private 중첩 클래스라면 데이터 필드를 노출해도 문제가 없다.
 * -> 그렇다 하더라도 필드에 직접적으로 접근하는것보다는 메서드를 통해서 접근하는 것이 더 좋다. (점진적인 변화 가능)
 */
public class Point
{
	private double x;
	private double y;
	
	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double getX()
	{
		// 부가 작업 가능
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public void setY(double y)
	{
		this.y = y;
	}
	
	public void setX(double x)
	{
		// 부가 작업 가능
		this.x = x;
	}
}


