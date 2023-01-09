package chapter01.item03.enumtype;

/**
 * item03. private 생성자나 열거 타입으로 싱글톤임을 보증하라.
 * 3) 열거타입
 * 리플렉션과 직렬화, 역직렬화에 안전하다.
 */
public enum Elvis
{
	INSTANCE;
	
	public void leaveTheBuilding()
	{
		System.out.println("Elvis.leaveTheBuilding");
	}
	
	
}
