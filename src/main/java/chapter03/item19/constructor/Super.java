package chapter03.item19.constructor;

/**
 * item19. 상속을 고려해 설계하고 문서화해라. 그렇지 않았더라면 상속을 금지하라.
 */
public class Super
{
	/**
	 * 재정의 가능 메서드를 호출하는 생성자 -> 따라하면 x
	 */
	public Super()
	{
		overrideMe(); // 생성자가 재정의 가능한 메서드를 호출하고 있다.
	}
	
	public void overrideMe()
	{
	
	}
}
