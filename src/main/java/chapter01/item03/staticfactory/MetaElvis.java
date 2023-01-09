package chapter01.item03.staticfactory;

/**
 *  * item03. private 생성자나 열거 타입으로 싱글톤임을 보증하라.
 *  * 2) private 생성자 + public static (정적 팩터리 메서드)
 *  장점: 정적 팩터리를 제네릭 싱글턴 팩터리로 만들 수 있다.
 */
public class MetaElvis<T>
{
	private static final MetaElvis<Object> INSTANCE = new MetaElvis();
	
	private MetaElvis()
	{
	
	}
	
	@SuppressWarnings("unchecked")
	public static <T> MetaElvis<T> getInstance()
	{
		return (MetaElvis<T>) INSTANCE; // 원하는 타입으로 형변환 할 수 있다.
	}
	
	public void say(T t)
	{
		System.out.println("t = " + t);
	}
	
	public void leaveTheBuilding()
	{
		System.out.println("Whoa baby, I'm outta here!");
	}
}
