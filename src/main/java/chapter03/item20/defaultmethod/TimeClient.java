package chapter03.item20.defaultmethod;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * item20. 추상클래스보다는 인터페이스를 우선하라.
 */
public interface TimeClient
{
	void setTime(int hour, int minute, int second);
	
	void setDate(int day, int month, int year);
	
	void setDateAndTime(int day, int month, int year, int hour, int minute, int second);
	
	LocalDateTime getLocalDateTime();
	
	static ZoneId getZoneId(String zoneString)
	{
		try
		{
			return ZoneId.of(zoneString);
		}
		catch (DateTimeException e) {
			System.err.println("Invalid time zone: " + zoneString + "; using default time zone instead");
			return ZoneId.systemDefault();
		}
	}
	
	// 자바 8부터 인터페이스도 디폴트 메서드를 제공할 수 있다.
	default ZonedDateTime getZoneDateTime(String zoneString)
	{
		return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
	}
	
}
