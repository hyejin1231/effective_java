package chapter03.item16.point.dimension;

import java.awt.*;

/**
 * item16. public 클래스에서는 public 필드가 아닌 메서드 접근자를 사용하라.
 * 완벽공략: Dimension 클래스는 public 클래스의 필드를 직접 노출해서 문제가 있는데 아직까지도 해결되지 못했다.
 * -> 따라서 값이 언제 어디서 변경될지 모르는 불안정성을 가지기 때문에 값을 copy해서 사용해야 하고
 * 이게 성능상 문제까지로 이어지게 된다. (불필요한 인스턴스를 만드는 작업들이 생기니까..)
 */
public class DimensionExample
{
	public static void main(String[] args)
	{
		Button button = new Button("Hello Button");
		button.setBounds(0, 0, 20, 10);
		
		Dimension size = button.getSize();
		System.out.println("size.height = " + size.height);
		System.out.println("size.height = " + size.height);
		
		doSomething(size);
	}
	
	private static void doSomething(Dimension size)
	{
		// 값을 copy 해서 사용해야 한다. -> 근데 한번으로 성능 저하가 일어나지는 않겠지만..이렇게 copy하는 자체가 불편하다!!
		Dimension dimension = new Dimension();
		dimension.width = size.width;
		dimension.height = size.height;
	}
}
