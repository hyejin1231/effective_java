package chapter03.item18.callback;

/**
 * item18. 상속보다는 컴포지션을 사용하라.
 * 완벽공략 - 콜백 프레임워크와 셀프문제
 */
class BobFunction implements FunctionToCall
{
	private final Service service;
	
	BobFunction(Service service)
	{
		this.service = service;
	}
	
	@Override
	public void call()
	{
		System.out.println("----- call -----");
	}
	
	@Override
	public void run()
	{
		// 래퍼로 감싸고 있는 내부 객체가 어떤 클래스 A의 콜백으로 B로 사용되는 경우 this 를 전달한다면
		// 해당 클래스 A는 래퍼가 아닌 내부 객체를 호출한다. (self 문제)
		this.service.run(this); // 오로지 자기 자신
	}
}
