package chapter02.item14;

import java.math.BigDecimal;

/**
 * item14. Comparable을 구현할지 고려하라.
 */
public class CompareToConvention
{
	public static void main(String[] args)
	{
		BigDecimal n1 = BigDecimal.valueOf(23134134);
		BigDecimal n2 = BigDecimal.valueOf(11231230);
		BigDecimal n3 = BigDecimal.valueOf(53534552);
		BigDecimal n4 = BigDecimal.valueOf(11231230);
		
		// p.88 반사성
		System.out.println("n1.compareTo(n1) = " + n1.compareTo(n1));
		
		// p.88 대칭성
		System.out.println("n1.compareTo(n2) = " + n1.compareTo(n2));
		System.out.println("n2.compareTo(n1) = " + n2.compareTo(n1));
		
		// p.89 추이성
		System.out.println("n3.compareTo(n1) > 0 = " + (n3.compareTo(n1) > 0));
		System.out.println("n1.compareTo(n2) > 0 = " + (n1.compareTo(n2) > 0));
		System.out.println("n3.compareTo(n2) > 0 = " + (n3.compareTo(n2) > 0));
		
		// p.89 일관성
		System.out.println("n4.compareTo(n2) = " + n4.compareTo(n2));
		System.out.println("n2.compareTo(n1) = " + n2.compareTo(n1));
		System.out.println("n4.compareTo(n1) = " + n4.compareTo(n1));
		
		// p.89 compareTo가 0이라면 equals는 true여야 한다. (아닐 수도 있고...)
		BigDecimal oneZero = new BigDecimal("1.0");
		BigDecimal oneZeroZero = new BigDecimal("1.00");
		System.out.println("oneZero.compareTo(oneZeroZero) = " + oneZero.compareTo(oneZeroZero)); // Tree, TreeMap
		System.out.println("oneZero.equals(oneZeroZero) = " + oneZero.equals(oneZeroZero)); // 순서가 없는 컬렉션
	}
	
}
