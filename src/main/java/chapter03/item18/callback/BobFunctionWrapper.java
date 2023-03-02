package chapter03.item18.callback;

/**
 * item18. 상속보다는 컴포지션을 사용하라.
 * 완벽공략 - 콜백 프레임워크와 셀프문제
 */
public class BobFunctionWrapper implements FunctionToCall
{
	private final BobFunction bobFunction;
	
	public BobFunctionWrapper(BobFunction bobFunction)
	{
		this.bobFunction = bobFunction;
	}
	
	@Override
	public void call()
	{
		this.bobFunction.call();
		System.out.println("----- another call -----");
	}
	
	@Override
	public void run()
	{
		this.bobFunction.run();
	}
}
