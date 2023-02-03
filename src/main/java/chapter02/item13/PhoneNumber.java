package chapter02.item13;

import java.util.HashMap;
import java.util.Map;

/**
 * item13. clone 재정의는 주의해서 진행하라.
 */
// 불변객체에서 clone을 구현하는 방법
public class PhoneNumber implements Cloneable{

    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum)
    {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
        System.out.println("constructor is called !");
    }
    
    /**
     * clone 대안 - copy 생성자를 만드는 방법
     * @param phoneNumber
     */
    public PhoneNumber(PhoneNumber phoneNumber)
    {
        this(phoneNumber.areaCode, phoneNumber.prefix, phoneNumber.lineNum);
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

    // PhoneNumber를 리턴하도록 해서 클라이언트가 사용할 때 타입 캐스팅을 하지 않아도 된다.
    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) { // 일어날 수 없는 일이다.
            throw new AssertionError(); // 대신 에러를 던져줬음
        }
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

    @Override
    public String toString()
    {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }

    public static PhoneNumber of(String phoneNumberString)
    {
        String[] split = phoneNumberString.split("-");
        PhoneNumber phoneNumber = new PhoneNumber(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        return phoneNumber;
    }

    public static void main(String[] args)
    {
        PhoneNumber phoneNumber = new PhoneNumber(707,867,5309);
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(phoneNumber, "혜진");
        PhoneNumber clone = phoneNumber.clone();
        System.out.println("m.get(clone) = " + m.get(clone));

        System.out.println("(clone != phoneNumber) = " + (clone != phoneNumber)); // 반드시 true
        System.out.println("(clone.getClass() == phoneNumber.getClass()) = " + (clone.getClass() == phoneNumber.getClass())); // 반드시 true
        System.out.println("clone.equals(phoneNumber) = " + clone.equals(phoneNumber)); // true가 아닐 수도 있다.

    }
}
