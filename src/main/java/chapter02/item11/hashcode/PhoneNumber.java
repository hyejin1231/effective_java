package chapter02.item11.hashcode;

import java.util.Objects;

/**
 * item11. equals를 재정의하려거든 hashcode도 재정의하라.
 */
public class PhoneNumber
{
	private final short areaCode, prefix, lineNum;
	
	public PhoneNumber(int areaCode, int prefix, int lineNum)
	{
		this.areaCode = rangeCheck(areaCode, 999, "area code");
		this.prefix = rangeCheck(prefix, 999, "prefix");
		this.lineNum = rangeCheck(lineNum, 9999, "line num");
	}
	
	private static short rangeCheck(int val, int max, String arg)
	{
		if (val < 0 || val > max) {
			throw new IllegalArgumentException(arg + ": " + val);
		}
			return (short) val;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (!(o instanceof PhoneNumber)) {
			return false;
		}
		PhoneNumber that = (PhoneNumber) o;
		return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
	}
	
	@Override
	public int hashCode()
	{
		return 42;
	}
	
	//	@Override
//	public int hashCode()
//	{
//		return Objects.hash(areaCode, prefix, lineNum);
//	}
}
