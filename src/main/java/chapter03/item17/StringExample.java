package chapter03.item17;

/**
 * item17. 변경가능성을 최소화 하라.
 */
public class StringExample
{
	public static void main(String[] args)
	{
		String name = "whiteShip";
		StringBuilder sb = new StringBuilder(name); // 가변 동반 클래스를 제공하여 단점 보완 가능
		sb.append("hyejin");
	}
}
