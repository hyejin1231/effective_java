package chapter01.item01;

/**
 * item01. 생성자 대신 정적 팩터리 메서드를 고려하라.
 * 완벽공략 - 열거타입
 * : Enum 타입의 장점은 값을 제한할 수 있는 점이 있다. (Type safety)
 * 하나의 인스턴스
 */
public enum OrderStatus
{
	PREPARING(0), SHIPPED(1), DELIVERING(2), DELIVERED(3);
	
	// 질문2) enum은 자바의 클래스처럼 생성자, 메소드, 필드를 가질 수 있는가? -> yse
	private int number;
	
	OrderStatus(int number)
	{
		this.number = number;
	}
}
