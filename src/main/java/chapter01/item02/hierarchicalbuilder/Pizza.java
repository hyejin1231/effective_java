package chapter01.item02.hierarchicalbuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * item02. 생성자에 매개변수가 많다면 빌더를 고려하라.
 * : 계층형 빌더 패턴
 *
 */
public abstract class Pizza
{
	public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
	
	final Set<Topping> toppings;
	
	abstract static class Builder<T extends Builder<T>>
	{
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		
		public T addTopping(Topping topping) // Builder의 sub클래스에 해당하는 Builder를 리턴하도록
		{
			toppings.add(Objects.requireNonNull(topping));
			return self(); // 하위 클래스에서 형변환 없이 메서드 연쇄 지원 가능 (simulated self-type)
		}
		
		abstract Pizza build();
		
		// 하위 클래스는 이 메서드를 재정의(overriding) 하여 "this"를 반환하도록 해야 한다.
		// 형변환을 줄일 수있다.
		protected abstract T self();
	}
	
	Pizza(Builder<?> builder) {
		toppings = builder.toppings.clone();
	}
	
}
