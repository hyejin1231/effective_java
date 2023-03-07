package chapter03.item21;

/**
 * item21. 인터페이스는 구현하는 쪽을 생각해 설계하라.
 */
public interface MakerInterface
{
	default void hello()
	{
		System.out.println("MakerInterface.hello");
	}
}
