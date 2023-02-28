package chapter03.item17;

/**
 * item17. 변경 가능성을 최소화 하라.
 */
public class ComplexExample
{
	public static void main(String[] args)
	{
		/** private 생성자를 사용하면 인스턴스를 만들 수 없는데.. 그렇다면 이 클래스는 어떻게 사용하는가?
		 * -> 정적팩터리를 사용
		 * 장점: final 클래스는 상속을 아예 막아버리지만 private 생성자를 사용하면 생성자를 좁힌 상태에서는 상속이 가능하다.
		 */
		Complex complex = Complex.valueOf(1, 0.22);
	}
}
