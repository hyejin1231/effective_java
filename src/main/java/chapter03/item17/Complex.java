package chapter03.item17;

import java.util.Objects;

/**
 * item17. 변경가능성을 최소화 하라.
 * :  불변 클래스 장점
 * - 함수형 프로그래밍에 적합하다.
 * - 불변 객체는 근본적으로 스레드 안전하여 따로 동기화할 필요가 없다.
 * - 불변 객체는 안심하고 공유할 수 있다.
 * - 실패 원자성을 제공한다.
 */
public /*final*/ class Complex
{
	private final double re;
	private final double im;
	
	public static final Complex ZERO = new Complex(0, 0);
	
	public static final Complex ONE = new Complex(1, 0);
	
	public static final Complex I = new Complex(0, 1);
	
	private Complex(double re, double im) // private 또는 package-private 생성자를 사용해서도 상속을 막을 수 있다.
	{
		this.re = re;
		this.im = im;
	}
	
	public double realPart()
	{
		return re;
	}
	
	public double imaginaryPart()
	{
		return im;
	}
	
	public Complex plus(Complex complex)
	{
		return new Complex(re + complex.re , im + complex.im);
	}
	
	/** private 생성자를 사용하면 인스턴스를 만들 수 없는데.. 그렇다면 이 클래스는 어떻게 사용하는가?
	 * -> 정적팩터리를 사용
	 */
	public static Complex valueOf(double re, double im)
	{
		return new Complex(re, im);
	}
	
	private static class MyComplex extends Complex
	{
		private MyComplex(double re, double im)
		{
			super(re, im);
		}
	}
	
	public Complex minus(Complex complex)
	{
		return new Complex(re - complex.re, im - complex.im);
	}
	
	public Complex times(Complex complex)
	{
		return new Complex(re * complex.re - im * complex.im , re * complex.im + im * complex.re);
	}
	
	public Complex divideBy(Complex complex)
	{
		double tmp = complex.re * complex.re + complex.im * complex.im;
		return new Complex((re * complex.re + im * complex.im) / tmp, (im * complex.re - re * complex.im) / tmp);
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Complex complex = (Complex) o;
		return Double.compare(complex.re,
							  re) == 0 && Double.compare(
				complex.im, im) == 0;
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(re, im);
	}
	
	@Override
	public String toString()
	{
		return "Complex{" +
				"re=" + re +
				", im=" + im +
				'}';
	}
}
