package chapter03.item18.callback;

/**
 * item18. 상속보다는 컴포지션을 사용하라.
 * 완벽공략 - 콜백 프레임워크와 셀프문제
 */
public class Service
{
	public void run(FunctionToCall functionToCall)
	{
		System.out.println("------ do later ------");
		functionToCall.call();
	}
	
	public static void main(String[] args)
	{
		Service service = new Service();
		BobFunction bobFunction = new BobFunction(service);
		BobFunctionWrapper bobFunctionWrapper = new BobFunctionWrapper(bobFunction);
//		bobFunction.run();
		bobFunctionWrapper.run();
	}
}
