package chapter01.item02.illegalargumentexception;

import java.time.LocalDate;

/**
 * item02. 생성자에 매개변수가 많다면 빌더를 고려하라.
 * 완벽공략 - IllegalArgumentException
 */
public class Order
{
	public void updateDeliveryDate(LocalDate deliveryDate)
	{
		if (deliveryDate.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("deliveryDate can't be earlier than " + LocalDate.now());
		}
	}
}
