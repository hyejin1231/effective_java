package chapter02.item13.copy_consructor;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * item13. clone 재정의는 주의해서 진행하라.
 */
public class HashSetExample
{
	public static void main(String[] args)
	{
		Set<String> hashSet = new HashSet<>();
		hashSet.add("hyejin");
		hashSet.add("clone");
		System.out.println("hashSet = " + hashSet);
		
		Set<String> treeSet = new TreeSet<>(hashSet);
		
		System.out.println("treeSet = " + treeSet);
	}
}
