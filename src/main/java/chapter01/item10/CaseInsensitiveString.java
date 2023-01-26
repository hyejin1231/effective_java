package chapter01.item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * item10. equals는 일반 규약을 지켜 재정의하라.
 * : 대칭성
 */
public class CaseInsensitiveString
{
	private final String s;
	
	public CaseInsensitiveString(String s)
	{
		this.s = Objects.requireNonNull(s);
	}
	
//	@Override
//	public boolean equals(Object obj)
//	{
//		if (obj instanceof CaseInsensitiveString) {
//			return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
//		}
//
//		if (obj instanceof String) {
//			return s.equalsIgnoreCase((String) obj);
//		}
//
//		return false;
//	}
	
	public static void main(String[] args)
	{
		CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
		CaseInsensitiveString cis2 = new CaseInsensitiveString("polish");
		String polish = "polish";
		System.out.println("cis.equals(polish) = " + cis.equals(polish));
		
		System.out.println("polish.equals(cis) = " + polish.equals(cis)); // A.equals(B) != B.equals(A) 대칭성 x
		
		System.out.println("cis.equals(cis2) = " + cis.equals(cis2));
		System.out.println("cis2.equals(cis) = " + cis2.equals(cis));
		
		
		List<CaseInsensitiveString> list = new ArrayList<>();
		list.add(cis);
		
		System.out.println("list.contains(polish) = " + list.contains(polish));
	}
	
	// 수정된 equals
	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof CaseInsensitiveString &&  ((CaseInsensitiveString) obj).s.equalsIgnoreCase(s);
	}
}
