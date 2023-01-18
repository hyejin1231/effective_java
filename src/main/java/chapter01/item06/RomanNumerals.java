package chapter01.item06;

import java.util.regex.Pattern;

/**
 * item06. 불필요한 객체생성을 피하라.
 * 2) 정규 표현식
 * 값 비싼 객체를 재사용해 성능을 개선한다!
 */
public class RomanNumerals {

    static boolean isRomanNumeralSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    // 값 비싼 객체를 재사용해서 성능을 개선한다.
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        boolean result = false;
        long start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            result = isRomanNumeralSlow("MCMLXXVI");
        }
        long end = System.nanoTime();
        System.out.println("(end - start) = " + (end - start));
        System.out.println("result = " + result);
    }
}
