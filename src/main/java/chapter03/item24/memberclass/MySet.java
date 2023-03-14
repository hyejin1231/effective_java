package chapter03.item24.memberclass;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * item24. 멤버 클래스는 되도록 static으로 만들라.
 * @param <E>
 */
public class MySet<E> extends AbstractSet<E>
{
	@Override
	public Iterator<E> iterator()
	{
		return new MyIterator();
	}
	
	@Override
	public int size()
	{
		return 0;
	}
	
	private class MyIterator implements Iterator<E>
	{
		@Override
		public boolean hasNext()
		{
			return false;
		}
		
		@Override
		public E next()
		{
			return null;
		}
	}
}
