package chapter01.item10;

import java.sql.Date;
import java.sql.Timestamp;

public class EqualsInJava extends Object
{
	
	public static void main(String[] args)
	{
		long time = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(time);
		Date date = new Date(time);
		
		// 대칭성 위배
		System.out.println("date.equals(timestamp) = " + date.equals(timestamp));
		System.out.println("timestamp.equals(date) = " + timestamp.equals(date));
	}
	
}
