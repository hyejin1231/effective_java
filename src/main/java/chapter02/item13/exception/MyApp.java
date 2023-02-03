package chapter02.item13.exception;

/**
 * item13. clone 재정의는 주의해서 진행하라.
 * 완벽공략 - UnCheckedException
 */
public class MyApp
{
	public void hello()
	{
		System.out.println("hello");
		throw new MyException();
	}
	
	public void hello(String name) throws MyCheckedException
	{
		if (name.equals("noUse")) {
			throw new MyCheckedException();
		}
	}
	
	public static void main(String[] args)
	{
		MyApp myApp = new MyApp();
		myApp.hello();
		
		try
		{
			myApp.hello("noUse");
		}
		catch (MyCheckedException e)
		{
			throw new RuntimeException(e);
		}
	}
}
