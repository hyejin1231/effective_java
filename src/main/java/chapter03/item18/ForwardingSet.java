package chapter03.item18;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * item18. 상속보다는 컴포지션을 사용하라.
 * 재사용할 수 있는 전달 클래스
 */
public class ForwardingSet<E> implements Set<E> // Set이 Component, ForwardingSet이 decorator
{
	private final Set<E> s;
	
	public ForwardingSet(Set<E> s)
	{
		this.s = s;
	}
	
	public void clear()
	{
		s.clear();
	}
	
	public boolean contains(Object o)
	{
		return s.contains(o);
	}
	
	public boolean isEmpty()
	{
		return s.isEmpty();
	}
	
	public int size()
	{
		return s.size();
	}
	
	public Iterator<E> iterator()
	{
		return s.iterator();
	}
	
	public boolean add(E e)
	{
		return s.add(e);
	}
	
	public boolean remove(Object o)
	{
		return s.remove(o);
	}
	
	public boolean containsAll(Collection<?> collection)
	{
		return s.containsAll(collection);
	}
	
	public boolean addAll(Collection<? extends E> collection)
	{
		return s.addAll(collection);
	}
	
	public boolean removeAll(Collection<?> c)
	{
		return s.removeAll(c);
	}
	
	public boolean retainAll(Collection<?> collection)
	{
		return s.retainAll(collection);
	}
	
	public Object[] toArray()
	{
		return s.toArray();
	}
	
	public <T> T[] toArray(T[] a)
	{
		return s.toArray(a);
	}
	
	
}
