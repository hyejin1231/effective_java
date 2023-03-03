package chapter03.item19.constructor;

import java.time.Instant;

/**
 * item19. 상속을 고려해서 설계하고 문서화하라. 그렇지 않았더라면 상속을 금지하라.
 * 생성자에서 호출하는 메서드를 재정의했을 때의 문제를 보여준다.
 */
public final class Sub extends Super
{
	// 초기화되지 않은 final 필드, 생성자에서 초기화한다.
	private final Instant instant;
	
	Sub()
	{
		instant = Instant.now();
	}
	
	// 재정의 가능한 메서드. 상위 클래스의 생성자가 호출한다.
	@Override
	public void overrideMe()
	{
		System.out.println(instant);
	}
	
	public static void main(String[] args)
	{
		// 하위 클래스의 생성자에서는 먼저 상위 클래스의 생성자를 호출하기 때문에
		// Super의 생성자를 호출 -> overrideMe() 호출 -> instant 초기화 아직 안됨 -> null 출력
		// 다음 직접 sub.overrideMe() 호출 시에는 이제 초기화 됨 -> 시간 출력
		Sub sub = new Sub();
		sub.overrideMe();
	}
}
