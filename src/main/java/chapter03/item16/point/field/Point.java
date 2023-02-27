package chapter03.item16.point.field;

/**
 * item16. public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라.
 * public 필드를 사용한 방법은 필드에 접근하려고 할 때 부수적인 작업을 할 수 없고,
 * 필드를 변경하려면 api를 변경해야 한다.
 */
public class Point
{
	public double x;
	public double y;
	
	public static void main(String[] args)
	{
		Point point = new Point();
		point.x = 10;
		point.y = 20;
	}
}
