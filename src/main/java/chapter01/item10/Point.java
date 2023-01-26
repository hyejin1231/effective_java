package chapter01.item10;

/**
 * item10. equals는 일반 규약을 지켜 재정의하라.
 * 추이성 A.equals(B)이고, B.equals(C)이면 A.equals(C) 이다.
 */
// 단순 붎변 2차원 정수 점(point) 클래스
public class Point
{
	private final int x;
	private final int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		// equals 구현 방법 1. == 연산자를 사용해 입력이 자기 자신의 참조인지 확인한다.
		if (this == obj) {
			return true;
		}
		
		// equals 구현 방법 2. instanceOf 연산자로 입력이 올바른 타입인지 확인한다.
		if (!(obj instanceof Point)) {
			return false;
		}

		// equals 구현 방법 3. 입력을 올바른 타입으로 형변환한다.
		Point p = (Point) obj;
		
		// equals 구현 방법 4. 입력 객체와 자기 자신의 대응되는 '핵심' 필드들이 모두 일치하는지 하나씩 검사한다.
		return p.x == x && p.y == y;
	}
	
	// 잘못된 코드: 리스코프 치환 원칙을 위배한다.
//	@Override
//	public boolean equals(Object obj)
//	{
//		if (obj == null || obj.getClass() != getClass()) {
//			return false;
//		}
//
//		Point p = (Point) obj;
//		return p.x == x && p.y == y;
// 	}
	
	@Override
	public int hashCode()
	{
		return 31 * x + y;
	}
}
