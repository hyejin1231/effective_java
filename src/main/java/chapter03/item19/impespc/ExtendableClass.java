package chapter03.item19.impespc;

/**
 * item19. 상속을 고려해 설계하고 문서화하라. 그렇지 않았더라면 상속을 금지하라.
 * Example class for java documentation for extendable class
 */
public class ExtendableClass
{
	/**
	 * This method can be overridden to print any message
	 *
	 * @implSpec
	 * Please use System.out.println()
	 */
	public void doSomething()
	{
		System.out.println("hello");
	}
}
