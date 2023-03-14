package chapter03.item24.memberclass;

/**
 * item24. 멤버 클래스는 되도록 static으로 만들라.
 */
public class OuterClass
{
	private int number = 10;
	
	void printNumber()
	{
		InnerClass innerClass = new InnerClass();
	}
	
	
	// 비정적 멤버 클래스 (static이 없는 inner class)
	// outer class의 인스턴스에 대한 참조가 암묵적으로 생긴다. -> 즉 outer class 없이는 inner class 사용 x
	private class InnerClass {
		void doSomething()
		{
			System.out.println("number = " + number);
			OuterClass.this.printNumber(); // outer class의 멤버에 접근 가능
		}
	}
	
	public static void main(String[] args)
	{
		InnerClass innerClass = new OuterClass().new InnerClass();
		innerClass.doSomething();
	}
}
