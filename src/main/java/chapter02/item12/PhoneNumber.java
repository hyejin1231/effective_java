package chapter02.item12;

/**
 * item12. toString을 항상 재정의하라.
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
	
	// toString이 반환된 값에 포함된 정보를 얻을 수 있는 API를 제공하는 것이 좋다.
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
		int result = Short.hashCode(areaCode);
		result = result + 31 * Short.hashCode(prefix);
		result =result +  31 * Short.hashCode(lineNum);
		
		return result;
	}
	
	/**
	 * 이 전화번호의 문자열 표현을 반환한다.
	 * 이 문자열은 "XXX-YYY-ZZZZ" 형태의 12글자로 구성된다.
	 * XXX는 지역코드, YYY는 프리픽스, ZZZZ는 가입자 번호다.
	 * 각각의 대문자는 10진수 숫자 하나를 나타낸다.
	 *
	 * 전화번호의 각 부분의 값이 너무 작아서 자릿수를 채울 수 없담ㄴ,
	 * 앞에서부터 0으로 채워나간다.
	 * 예로 가입자 번호가 123이라면 전화번호의 마지막 네 문자는 "0123"이다.
	 */
	@Override
	public String toString()
	{
		return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
	}
	
	/**
	 * 정적 팩터리나 생성자를 제공하는 것도 좋다.
	 * @param phoneNumberString
	 * @return
	 */
	public static PhoneNumber of(String phoneNumberString)
	{
		String[] split = phoneNumberString.split("-");
		PhoneNumber phoneNumber = new PhoneNumber(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
		return phoneNumber;
	}
	
	public static void main(String[] args)
	{
		PhoneNumber phoneNumber = new PhoneNumber(707,867,5309);
		System.out.println("phoneNumber = " + phoneNumber);
		
		PhoneNumber of = PhoneNumber.of("707-867-5309");
		System.out.println("PhoneNumber.of = " + phoneNumber);
		
		System.out.println("phoneNumber.equals(of) = " + phoneNumber.equals(of));
		System.out.println("phoneNumber.hashCode() == of.hashCode() = " + (phoneNumber.hashCode() == of.hashCode()));
	}
}
