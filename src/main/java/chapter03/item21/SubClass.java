package chapter03.item21;

/**
 * item21. 인터페이스는 구현하는 쪽을 생각해 설계하라.
 */
public class SubClass extends Superclass implements MakerInterface
{
	public static void main(String[] args)
	{
		SubClass subClass = new SubClass();
		subClass.hello(); // error 발생 ! -> class는 interface보다 우선하기 때문에 class의 hello 를 사용하려고 하고, private 라서 이제 error발생
	}
}
