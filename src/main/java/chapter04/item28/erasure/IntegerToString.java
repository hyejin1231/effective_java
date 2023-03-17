package chapter04.item28.erasure;

import java.util.ArrayList;
import java.util.List;

/**
 * item28. 배열보다는 리스트를 사용하라.
 */
public class IntegerToString
{
	public static void main(String[] args)
	{
		// 공변
		Object[] anything = new String[10]; // String 타입을 Object 타입에 담을 수 있다. (호환이 되기 때문에)
		anything[0] = 1; // 컴파일 에러가 나지 않지만 문제가 있는 코드다.  (문자열 배열인데 숫자를 넣고 있으므로 버그다..!)
		
		// 불공변
		List<String> names = new ArrayList<>();
//		List<Object> objects = names; // List<String>을 List<Object>에 넣을 수 없다. compile error 발생
	}
}
