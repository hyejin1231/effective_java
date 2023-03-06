package chapter03.item20.templatemethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.BiFunction;

/**
 * item20. 추상클래스보다 인터페이스를 우선하라.
 * 완벽공략 - 템플릿 메서드 패턴
 * -> 상속을 사용하지 않고도 할 수 있는 방법..>  템플릿 콜백 패턴
 */
public  class CallbackFileProcessor
{
	private String path;
	
	public CallbackFileProcessor(String path)
	{
		this.path = path;
	}
	
	public final int process(BiFunction<Integer, Integer, Integer> operator)
	{
		try(BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			int result = 0;
			String line = null;
			while((line = reader.readLine()) != null)
			{
				result = operator.apply(result, Integer.parseInt(line));
			}
			return result;
		}
		catch (IOException e)
		{
			throw new IllegalArgumentException(path + "에 해당하는 파일이 없습니다.", e);
		}
	}
}
