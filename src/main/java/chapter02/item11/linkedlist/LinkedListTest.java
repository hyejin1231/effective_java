package chapter02.item11.linkedlist;

import java.util.LinkedList;

/**
 * item11. equals를 재정의하려거든 hashCode도 재정의하라.
 * 완벽공략 - 해시맵 내부 연결리스트 linkedList
 */
public class LinkedListTest
{
	public static void main(String[] args)
	{
		LinkedList<String> linkedList = new LinkedList<>();
		
		// LinkedList 값 추가
		linkedList.add("Hello");
		linkedList.add("Hi");
		linkedList.add("Bye");
		
		System.out.println("linkedList = " + linkedList);
		
		// LinkedList 값 수정
		linkedList.set(0, "Hello_new");
		System.out.println("linkedList = " + linkedList);
		
		linkedList.add("Remove this Data");
		System.out.println("linkedList = " + linkedList);
		
		// LinkedList 값 삭제
		linkedList.remove(3);
		System.out.println("linkedList = " + linkedList);
		
		// LinkedList 크기 구하기
		System.out.println("linkedList.size() = " + linkedList.size());
		
		// LinkedList 값 꺼내기
		System.out.println("linkedList.get(1) = " + linkedList.get(1));
		
		// LinkedList 값 검색하기
		System.out.println("linkedList.contains(\"Hi\") = " + linkedList.contains("Hi"));
	}
}
