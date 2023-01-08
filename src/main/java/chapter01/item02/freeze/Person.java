package chapter01.item02.freeze;

import java.util.List;

/**
 * item02. 생성자에 매개변수가 많다면 빌더를 고려하라.
 * 완벽공략 : 객체 프리징
 * 근데 강사도 이런 코드를 한번도 본적 없다고 한다..! 왜냐하면 런타임에 갑자기 객체 얼리기를 하고..
 * 그 다음부터는 프로퍼티 수정 등이 불가능하게 하려면 코딩이 상당히 어려워진다..
 */
public class Person
{
	private String name;
	private int birthYear;
	
	private List<String> kids;
	
	public Person(String name, int birthYear, List<String> kids)
	{
		this.name = name;
		this.birthYear = birthYear;
		this.kids = kids;
	}
	
	public void setName(String name)
	{
		checkIfObjectIsFrozen();
		this.name = name;
	}
	
	public void setBirthYear(int birthYear)
	{
		this.birthYear = birthYear;
	}
	
	public void setKids(List<String> kids)
	{
		this.kids = kids;
	}
	
	private void checkIfObjectIsFrozen()
	{
//		if (this.frozen()) {
//			throw new IllegalArgumentException();
//		}
	}
}
