package chapter02.item14;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * item14. Comparable을 구현할지 고민하라.
 */
public class PhoneNumber implements Comparable<PhoneNumber>
{
	private final short areaCode, prefix, lineNum;
	
	public PhoneNumber(int areaCode, int prefix, int lineNum)
	{
		this.areaCode = rangeCheck(areaCode, 999, "area code");
		this.prefix = rangeCheck(prefix, 999, "prefix");
		this.lineNum = rangeCheck(lineNum, 9999, "line num");
		System.out.println("constructor is called !");
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
		if (!(o instanceof PhoneNumber))
			return false;
		PhoneNumber that = (PhoneNumber) o;
		return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(areaCode, prefix, lineNum);
	}
	
	@Override
	public String toString()
	{
		return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
	}
	
	// 기본 타입 필드가 여럿일 때의 비교자
	@Override
	public int compareTo(PhoneNumber o)
	{
		int result = Short.compare(areaCode, o.areaCode);
		if (result == 0) {
			result = Short.compare(prefix, o.prefix);
			
			if (result == 0) {
				result = Short.compare(lineNum, o.lineNum);
			}
		}
		return result;
	}
	
	private static PhoneNumber randomPhoneNumber()
	{
		ThreadLocalRandom current = ThreadLocalRandom.current();
		return new PhoneNumber((short) current.nextInt(1000),
							   (short) current.nextDouble(1000),
							   (short) current.nextDouble(10000));
	}
	
	public static void main(String[] args)
	{
		Set<PhoneNumber> s = new TreeSet<>();
		for (int i = 0; i< 10; i++)
		{
			s.add(randomPhoneNumber());
		}
		
		System.out.println("s = " + s);
	}
	
}
