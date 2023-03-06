package chapter03.item20.templatemethod;

/**
 * item20. 추상클래스보다 인터페이스를 우선하라.
 * 완벽공략 - 템플릿 메서드 패턴
 */
public class Plus extends FileProcessor
{
	public Plus(String path)
	{
		super(path);
	}
	
	@Override
	protected int getResult(int result, int parseInt)
	{
		return result + parseInt;
	}
}
