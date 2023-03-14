package chapter03.item24.localclass;

/**
 * item24. 멤버 클래스는 되도록 static으로 만들라.
 */
public class MyClass
{
	private int number = 10;
	
	void doSomething()
	{
		// 멤버 클래스가 아닌 local class -> 거의 사용 x
		class LocalClass {
			private void printNumber()
			{
				System.out.println("number = " + number);
			}
		}
		
		LocalClass localClass = new LocalClass();
		localClass.printNumber();
	}
	
	public static void main(String[] args)
	{
		MyClass myClass = new MyClass();
		myClass.doSomething();
	}
}
