package chapter03.item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * item18. 상속보다는 컴포지션을 사용하라.
 * 상속의 잘못된 예
 */
public class InstrumentedHashSet<E> extends HashSet<E>
{
	// 추가된 원소의 수
	private int addCount = 0;
	
	public InstrumentedHashSet()
	{
	
	}
	
	public InstrumentedHashSet(int initCap, float loadFactor)
	{
		super(initCap, loadFactor);
	}
	
	@Override
	public boolean add(E e)
	{
		addCount++;
		return super.add(e);
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c)
	{
		addCount += c.size();
		return super.addAll(c); // addAll에서 add를 하기 때문에.. 상위 클래스의 구현을 파악하고 있어야 한다. -> 캡슐화가 깨진다.
	}
	
	public int getAddCount()
	{
		return addCount;
	}
	
	public static void main(String[] args)
	{
		InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
		// 3이 아닌 6이 된다.
		// 상속한 클래스의 add를 호출하기 때문에!
		s.addAll(List.of("틱", "탁탁", "펑"));
		System.out.println("s.getAddCount() = " + s.getAddCount());
	}
}
