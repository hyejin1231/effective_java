package chapter01.item03.enumtype;

import java.lang.reflect.Constructor;

public class EnumElvisReflection
{
	public static void main(String[] args)
	{
		try
		{
			Constructor<Elvis> declaredConstructor = Elvis.class.getDeclaredConstructor();
			System.out.println("declaredConstructor = " + declaredConstructor); // enum은 리플렉션으로 못가져옴 (내부적으로 막아둬서 못가져옴) 에러 발생!
		}
		catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
