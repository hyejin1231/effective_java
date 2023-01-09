package chapter01.item03.field;

/**
 * item03. private 생성자나 열거 타입으로 싱글톤임을 보증하라.
 * : 생성자는 private로 감추고, 유일한 인스턴스에 접근할 수 있는 수단으로 public static 멤버를 하나 만든다.
 */
public class Elvis
{
	// 싱글톤 오브젝트
	public static final Elvis INSTANCE = new Elvis();
	
	private Elvis()
	{
	
	}
	
	public void leaveTheBuilding()
	{
		System.out.println("Whoa baby, I'm outta here!");
	}
	
	public void sing()
	{
		System.out.println("I'll have a blue ~ Christmas without you~");
	}
	

	
}
