package chapter03.item17;

import java.math.BigInteger;

/**
 * item17. 변경 가능성을 최소화 하라.
 */
public class BigIntegerUtils
{
	/**
	 * BigInteger는 상속이 가능한 public 클래스라서 지금 파라미터로 들어온 BigInteger가 이를 상속한 클래스인지 모르기 때문에..
	 * 이  파라미터를 확인해서 BigInteger로 사용하겠다 !!
	 * @param val
	 * @return
	 */
	public static BigInteger safeInstance(BigInteger val)
	{
		return val.getClass() == BigInteger.class ? val : new BigInteger(val.toByteArray());
	}
}
