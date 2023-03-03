package chapter03.item20.defaultmethod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * item20. 추상클래스보다는 인터페이스를 우선하라.
 */
public class SimpleTimeClient implements TimeClient
{
	private LocalDateTime localDateTime;
	
	public SimpleTimeClient()
	{
		localDateTime = LocalDateTime.now();
	}
	
	@Override
	public void setTime(int hour, int minute, int second)
	{
		LocalDate currentDate = LocalDate.from(localDateTime);
		LocalTime timeToSet = LocalTime.of(hour, minute, second);
		localDateTime = LocalDateTime.of(currentDate, timeToSet);
	}
	
	@Override
	public void setDate(int day, int month, int year)
	{
		LocalDate dateToSet = LocalDate.of(day, month, year);
		LocalTime currentTime = LocalTime.from(localDateTime);
		localDateTime = LocalDateTime.of(dateToSet, currentTime);
	}
	
	@Override
	public void setDateAndTime(int day, int month, int year, int hour,
			int minute, int second)
	{
		LocalDate dateToSet = LocalDate.of(day, month, year);
		LocalTime timeToSet = LocalTime.of(hour, minute, second);
		localDateTime = LocalDateTime.of(dateToSet, timeToSet);
	}
	
	@Override
	public LocalDateTime getLocalDateTime()
	{
		return localDateTime;
	}
	
	public String toString()
	{
		return localDateTime.toString();
	}
	
	public static void main(String[] args)
	{
		TimeClient myTimeClient = new SimpleTimeClient();
		System.out.println("myTimeClient = " + myTimeClient);
		System.out.println(
				"myTimeClient.getZoneDateTime = " + myTimeClient.getZoneDateTime("America/Los_Angeles"));
	}
}
