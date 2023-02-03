package chapter02.item13.inheritance;

/**
 * item13. clone 재정의는 주의해서 진행하라.
 */
public class Square extends Shape
{
	private int length, height;
	
	public Square(int length, int height)
	{
		this.length = length;
		this.height = height;
	}
	
	@Override
	public int getArea()
	{
		return this.length * this.height;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException
	{
		Square square = new Square(10, 2);
		Square clone = (Square) square.clone();
		System.out.println("clone.getArea() = " + clone.getArea());
	}
}
