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
