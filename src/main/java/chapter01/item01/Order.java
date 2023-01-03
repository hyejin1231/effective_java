package chapter01.item01;

/**
 * item01. 생성자 대신 정적 팩터리 메서드를 고려하라.
 * : 생성자의 signature 가 겹치면 정적 팩터리 메서드 생성을 고려해보자.
 */
public class Order
{
	private boolean prime;
	private boolean urgent;
	private Product product;
	
	// 열거타입 Enum
	// 다른 값이 들어갈 수 없다는 장점이 있다.
	private OrderStatus orderStatus;
	
	// 0 - 주문 받음
	// 1 - 준비중
	// 2 - 배송중
	// 3 - 배송 완료
	private int status; // 정의되지 않은 값이 들어갈 수도 있다.
	private final int PREPARING = 0;
	private final int SHIPPED = 2;
	
	// 정적 팩터리 메서드
	// 장점1. 생성자의 signature가 겹치면 생성자로는 구분하기 힘들지만 정적 팩터리 메서드를 사용해서 구분할 수 있다.
	public static Order primeOrder(Product product)
	{
		Order order = new Order();
		order.prime = true;
		order.product = product;
		return order;
	}
	
	public static Order urgentOrder(Product product)
	{
		Order order = new Order();
		order.urgent = true;
		order.product = product;
		return order;
	}
}
