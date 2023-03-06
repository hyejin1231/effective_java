package chapter03.item20.multipleinheritance;

/**
 * item20.추상클래스보다 인터페이스를 우선하라.
 */
public class MyCat extends AbstractCat implements Flyable
{
	private MyFlyable myFlyable = new MyFlyable();
	
	@Override
	protected String sound()
	{
		return "My cat sound is noise";
	}
	
	@Override
	protected String name()
	{
		return "My cat name is 낭만고양이";
	}
	
	public static void main(String[] args)
	{
		MyCat myCat = new MyCat();
		System.out.println("myCat.sound() = " + myCat.sound());
		System.out.println("myCat.name() = " + myCat.name());
		myCat.fly();
	}
	
	@Override
	public void fly()
	{
		this.myFlyable.fly();
	}
	
	private class MyFlyable extends AbstractFlyable
	{
		@Override
		public void fly()
		{
			System.out.println("MyFlyable~~~~~~~!!!!!!!!!!");
		}
	}
	
}
