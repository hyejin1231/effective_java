package chapter04.item28.erasure;

import java.util.ArrayList;
import java.util.List;

/**
 * item28. 배열보다는 리스트를 사용하라.
 */
public class MyGeneric
{
	public static void main(String[] args)
	{
		// 컴파일하고 나면 제네릭이 사라진다. (소거) -> 하위 호환성을 위해서 소거의 방법을 사용하고 형변환 코드를 넣어줌
		List<String> names = new ArrayList<>();
		names.add("hyejin");
		String name = names.get(0);
		System.out.println("name = " + name);
	}
}
