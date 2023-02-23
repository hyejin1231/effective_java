package chapter03.item15.class_and_interface.item;

import chapter03.item15.class_and_interface.member.MemberService;

/**
 * item15. 클래스나 멤버의 접근 권한을 최소화하라.
 * public 클래스의 인스턴스 필드는 되도록 public이 아니어야 한다.
 */
public class ItemService
{
	public static final String NAME = "HYEJIN";
	private MemberService memberService;
	
	boolean onSale;
	
	protected int saleRate;
	
	public ItemService(MemberService memberService)
	{
		this.memberService = memberService;
	}
}
