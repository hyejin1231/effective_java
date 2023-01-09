package chapter01.item02.varargs;

import java.util.Arrays;

/**
 * item02. 생성자에 매개변수가 많다면 빌더를 고려하라.
 * 완벽 공략 - 가변 인수
 */
public class VarargsSamples
{
	// 가변 인수는 오직 하나만 선언해야 한다. (사용한다면 마지막에 선언해야함)
	public void printNumbers(int... numbers)
	{
		System.out.println(numbers.getClass().getCanonicalName()); // numbers가 어떤 타입일건지
		System.out.println(numbers.getClass().getComponentType()); // 배열이 어떤 타입을 가지는지
		Arrays.stream(numbers).forEach(System.out::println); // 가변 인수가 가지는 값 출력
	}
	
	public static void main(String[] args)
	{
		VarargsSamples varargsSamples = new VarargsSamples();
		varargsSamples.printNumbers(5, 10);
		
	}
}
