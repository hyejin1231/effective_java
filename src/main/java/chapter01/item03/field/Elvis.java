package chapter01.item03.field;

import java.io.Serializable;

/**
 * item03. private 생성자나 열거 타입으로 싱글톤임을 보증하라.
 * 1) private 생성자 + public static final 필드
 */
public class Elvis implements Serializable
{
	// 싱글톤 오브젝트
	public static final Elvis INSTANCE = new Elvis();
	private static boolean created;
	
	private Elvis()
	{
		if (created) {
			// 리플렉션 공격을 방어하려면 생성자를 수정하여 두 번째 객체가 생성되려 할 때 예외를 던지게 하면 된다.
			throw new UnsupportedOperationException("can't be created by constructor");
		}
		created = true;
	}
	
	public void leaveTheBuilding()
	{
		System.out.println("Whoa baby, I'm outta here!");
	}
	
	public void sing()
	{
		System.out.println("I'll have a blue ~ Christmas without you~");
	}
	
	// 싱글톤임을 보장해주는 readResolve 메서드
	// 역직렬화를 할 때 readResolve라는 메서드를 사용하는데 여기를 싱글톤으로 생성한 INSTANCE를 반환해주면
	// 역직렬화 할 때 새로운 인스턴스를 생성하지 않는다.
	private Object readResolve()
	{
		return INSTANCE;
	}
	

	
}
