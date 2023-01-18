package chapter01.item06;

/**
 * item06. 불필요한 객체 생성을 피하라.
 * 완벽공략 - deprecation
 */
public class Deprecation
{
	/**
	 * @deprecated in favor of
	 * {@link #Deprecation(String)}
	 */
	// TODO 애노테이션 프로세서
	// forRemoval 옵션을 사용하면 더 강력하게 알려주는 것!
	@Deprecated(forRemoval = true, since = "1.2")
	public Deprecation()
	{
	}
	
	private String name;
	
	public Deprecation(String name)
	{
		this.name = name;
	}
}
