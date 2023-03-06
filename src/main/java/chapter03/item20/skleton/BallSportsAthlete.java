package chapter03.item20.skleton;

/**
 * 추상 골격 구현 클래스
 * : 디폴트 메서드를 사용하는 것이 아니라 추상 골격 클래스를 사용해서 코드 중복을 제거할 수 있다.
 */
abstract class BallSportsAthlete implements Athlete
{
	@Override
	public void 근력운동()
	{
		System.out.println("BallSportsAthlete.근력운동");
	}
	
	@Override
	public void 체력증진()
	{
		System.out.println("BallSportsAthlete.체력증진");
	}
	
	@Override
	public void 루틴()
	{
		근력운동();
		체력증진();
		연습();
	}
}
