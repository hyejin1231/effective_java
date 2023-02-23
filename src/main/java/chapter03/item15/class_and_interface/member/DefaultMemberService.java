package chapter03.item15.class_and_interface.member;

import java.util.Arrays;

/**
 * item15. 클래스와 멤버의 접근 권한을 최소화하라.
 *  package-private를 사용해도 되지 않을까?
 *  왜냐하면 DefaultMemberService는 MemberService의 구현체로 내부에서만 알아도 되지 않는가? -> 외부(클라이언트)에서는 알 필요가 없지 않나
 */
class DefaultMemberService implements MemberService
{
	private String name;
	
	/**
	 * 한 클래스에서만 사용하는 package-private 클래스나 인터페이스는
	 * 해당 클래스에 private static으로 중첩 시키자 !
	 */
	private static class PrivateStaticClass
	{
		// 별도의 클래스로 존재하던 것을 한 클래스에서만 사용한다면 중첩시키자~ 해서 가져온 것이기 때문에
		// 이렇게 private static으로 중첩시키는 것이 맞다. (DefaultMemberSerivce와 독립적인 관계)
	}
	
	private class PrivateClass
	{
		void doPrint() // 내부 클래스는 자기 자신을 감싸는 외부 클래스의 인스턴스를 가지고 있기 때문에 그냥 name을 사용할 수 있다.
		{
			System.out.println("name = " + name);
		}
	}
	
	public static void main(String[] args)
	{
		// final chapter03.item15.class_and_interface.member.DefaultMemberService chapter03.item15.class_and_interface.member.DefaultMemberService$PrivateClass.this$0
		Arrays.stream(PrivateClass.class.getDeclaredFields()).forEach(System.out::println);
	}
	
}
