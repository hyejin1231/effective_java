package chapter01.item01;

/**
 * item01. 생성자 대신 정적 팩터리 메서드를 고려하라.
 * 완벽공략 - Flyweight Pattern
 * : 인스턴스를 가능한 한 공유해서 사용함으로써 메모리를 절약하는 패턴
 * : 자주 변하는 속성과 변하지 않는 속성을 분리하고 재사용하여 메모리 사용을 줄일 수 있다.
 */
// 공유할 Tree 객체
public class Tree
{
	private String color;
	private int x;
	private int y;
	
	public Tree(String color)
	{
		this.color = color;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void install()
	{
		System.out.println("x : " + x + " y : " + y + " 위치에 " + color + "색 나무를 심었습니다.");
	}
}
