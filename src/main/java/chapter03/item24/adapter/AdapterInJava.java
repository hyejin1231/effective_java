package chapter03.item24.adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * item24. 멤버 클래스는 되도록 static 으로 만들라.
 * 완벽공략 - 어댑터 패턴
 * : 기존 코드를 클라이언트가 사용하는 인터페이스의 구현체로 바꿔주는 패턴
 */
public class AdapterInJava
{
	public static void main(String[] args)
	{
		// 어댑터 패턴의 대표적인 예제
		try (InputStream is = new FileInputStream("number.txt");
			 InputStreamReader isr = new InputStreamReader(is);
			 BufferedReader reader = new BufferedReader(isr))
		{
			while (reader.ready())
			{
				System.out.println(reader.readLine());
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
