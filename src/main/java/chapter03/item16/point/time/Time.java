package chapter03.item16.point.time;

/**
 * item16. public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라.
 */
public class Time
{
	private static final int HOURS_PER_DAY = 24;
	private static final int MINUTES_PER_HOUR = 60;
	
	// public 클래스의 필드가 불변이라면 직접 노출할 때 단점이 조금 줄어들지만 이게 좋은 생각은 아니다.
	public final int hour;
	public final int minute;
	
	public Time(int hour, int minute)
	{
		if (hour < 0 || hour >= HOURS_PER_DAY) {
			throw new IllegalArgumentException("Hour: " + hour);
		}
		
		if (minute < 0 || minute >= MINUTES_PER_HOUR) {
			throw new IllegalArgumentException("Min : " + minute);
		}
		this.hour = hour;
		this.minute = minute;
	}
}
