package chapter03.item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * item18. 상속보다는 컴포지션을 사용하라.
 * 상속대신 컴포지션을 사용한 클래스
 */
public class InstrumentedSet<E> extends ForwardingSet<E>
{
	private int addCount = 0;
	public InstrumentedSet(Set<E> s)
	{
		super(s);
	}
	
	@Override
	public boolean add(E e)
	{
		addCount++;
		return super.add(e);
	}
	
	@Override
	public boolean addAll(Collection<? extends E> collection)
	{
		addCount += collection.size();
		return super.addAll(collection);
	}
	
	public int getAddCount()
	{
		return addCount;
	}
	
	public static void main(String[] args)
	{
		InstrumentedSet<String> s = new InstrumentedSet<>(new HashSet<>());
		s.addAll(List.of("틱", "탁탁", "펑"));
		System.out.println("s.getAddCount() = " + s.getAddCount());
	}
}
