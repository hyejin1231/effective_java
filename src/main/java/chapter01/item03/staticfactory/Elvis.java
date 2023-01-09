package chapter01.item03.staticfactory;

/**
 * item03. private 생성자나 열거 타입으로 싱글톤임을 보증하라.
 * 2) private 생성자 + public static (정적 팩터리 메서드)
 * 단점: 리플렉션, 역직렬화, 테스트에 대한 문제는 여전히 존재한다.
 * 장점: 싱글톤 아니도록 변경도 가능하다.
 */
public class Elvis implements Singer
{
	private static final Elvis INSTANCE = new Elvis();
	
	private Elvis()
	{
	
	}
	
	public static Elvis getInstance()
	{
		return INSTANCE; // return new Elvis();를 하는 순간 싱글톤 아니게도 변경 가능
	}
	
	public void leaveTheBuilding()
	{
		System.out.println("Whoa baby, I'm outta here!");
	}
	
	@Override
	public void sing()
	{
		System.out.println("my way~~~~~~~");
	}
}
