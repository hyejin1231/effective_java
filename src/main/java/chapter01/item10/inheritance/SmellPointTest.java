package chapter01.item10.inheritance;

import chapter01.item10.Color;

/**
 * item10. equals는 기본 규약을 지켜 재정의하라.
 * 완벽공략 - StackOverflowError
 */
public class SmellPointTest
{
	public static void main(String[] args)
	{
		SmellPoint smellPoint = new SmellPoint(0, 1, "sweat");
		ColorPoint colorPoint = new ColorPoint(0, 1, Color.RED);
		smellPoint.equals(colorPoint); // stackoverflowError 발생
	}
}
