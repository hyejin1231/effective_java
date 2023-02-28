package chapter03.item17.memorymodel;

/**
 * item17. 변경 가능성을 최소화 하라.
 * 완벽공략 - final과 자바 메모리 모델 JMM
 */
public class WhiteShip
{
	// final 필드가 초기화가 되어야만 사용할 수 있기 때문에
	// 해당 인스턴스가 생성될 때 반드시 값을 가지고 초기화가 되어야 한다면 final 키워드를 써야한다
	// 사용 안하면 멀티 스레드 환경에서 해당 값이 초기화되지 않은 상태에서 참조될 가능성이 있기 때문이다.
	// (근데 강사님도 한번도 이런 경험을 해본적은 없다고는 하지만 자바 메모리 모델 문서에서는 가능성이 있다고 하니까~~)
	private final int x;
	private final int y;
	
	public WhiteShip()
	{
		this.x = 1;
		this.y = 2;
	}
	
	public static void main(String[] args)
	{
		// (원래 생각의 동작 순서)
		// Object o =  new WhiteShip()
		// o.x = 1
		// o.y = 2
		// whiteSip = o
		
		// 메모리 모델이 허용하는 범위내에서 프로그램을 어떻게 실행하든 구현체의 자유! -> 따라서 실행 순서가 바뀔수도 있다.
		
		// (실행 순서 변경)
		// Object o =  new WhiteShip()
		// whiteSip = o
		// o.x = 1
		// o.y = 2
		WhiteShip whiteShip = new WhiteShip();
	}
	
	
}
