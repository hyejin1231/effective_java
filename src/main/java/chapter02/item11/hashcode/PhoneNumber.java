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
	
//	@Override
//	public int hashCode()
//	{
//		return 42;
//	}
	
	// 전형적인 hashCode 메서드
//	@Override
//	public int hashCode()
//	{
//		int result = Short.hashCode(areaCode);
//		result = 31 * result + Short.hashCode(prefix);
//		result = 31 * result + Short.hashCode(lineNum);
//		return result;
//	}
	
	// 한줄 코드 (Intelli J 도움)
//	@Override
//	public int hashCode()
//	{
//		return Objects.hash(areaCode, prefix, lineNum);
//	}
	
	// 불변일 때,
	// 해시코드를 지연 초기화하는 hashCode, 주의할 점은 스레드 안정성까지 고려해야 한다.
	private volatile int hashCode; // 자동으로 0으로 초기화된다.
	
	// 멀티 스레드 안전한 방법
	@Override
	public int hashCode()
	{
		if (this.hashCode != 0) {
			return hashCode;
		}
		
		synchronized (this) {
			int result = hashCode;
			if (result == 0) {
				result = Short.hashCode(areaCode);
				result  = 31 * result + Short.hashCode(prefix);
				result = 31 * result + Short.hashCode(lineNum);
				hashCode = result;
			}
			return result;
		}
	}
	
	// 스레드 안전해 보이지만 스레드 안전하지는 않았던 코드
//	@Override
//	public int hashCode()
//	{
//		int result = hashCode;
//		if (result == 0) {
//			result = Short.hashCode(areaCode);
//			result  = 31 * result + Short.hashCode(prefix);
//			result = 31 * result + Short.hashCode(lineNum);
//			hashCode = result;
//		}
//		return result;
//	}


}
