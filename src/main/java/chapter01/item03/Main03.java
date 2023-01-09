package chapter01.item03;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import chapter01.item03.field.Elvis;

public class Main03
{
	public static void main(String[] args)
	{
		Elvis elvis = Elvis.INSTANCE;
		elvis.leaveTheBuilding();
		
		// 생성자로 여러 인스턴스 만들기
		// 리플렉션을 사용하면 다른 인스턴스를 만들 수 있게 된다..!!!
		try
		{
			Constructor<Elvis> defaultConstructor = Elvis.class.getDeclaredConstructor();
			defaultConstructor.setAccessible(true); // true 로 안하면 Elvis는 생성자가 private여서 호출할 수 없게됨
			Elvis elvis1 = defaultConstructor.newInstance();
			Elvis elvis2 = defaultConstructor.newInstance();
			System.out.println("(elvis1 == elvis2) = " + (elvis1 == elvis2));
		}
		catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e)
		{
			throw new RuntimeException(e);
		}
		
		
	}
}
