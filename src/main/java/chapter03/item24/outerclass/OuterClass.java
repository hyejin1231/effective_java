package chapter03.item24.outerclass;

/**
 * item24. 멤버 클래스는 되도록 static으로 만들라.
 */
public class OuterClass
{
	private static int number = 10;
	
	
	// static 멤버 클래스
	// static 필드에 접근 가능
	// Outer class의 인스턴스를 필요로 하지 않는다. (static이라 outer class와 독립적)
	static private class InnerClass {
		void doSomething()
		{
			System.out.println("number = " + number);
		}
	}
	
	public static void main(String[] args)
	{
		InnerClass innerClass = new InnerClass();
		innerClass.doSomething();
		
	}
}
