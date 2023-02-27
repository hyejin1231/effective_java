package chapter03.item17;

/**
 * item17. 변경 가능성을 최소화하라.
 * - 객체의 상태를 변경하는 메서드를 제공하지 않는다.
 */
public final class PhoneNumber // 클래스를 확장할 수 없도록 한다.
{
	private final short areaCode, prefix, lineNum; // 모든 필드를 final로 선언, 모든 필드는 private으로 선언
	
	public PhoneNumber(short areaCode, short prefix, short lineNum)
	{
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNum = lineNum;
	}
	
	public short getAreaCode()
	{
		return areaCode;
	}
	
	public short getPrefix()
	{
		return prefix;
	}
	
	public short getLineNum()
	{
		return lineNum;
	}
}
