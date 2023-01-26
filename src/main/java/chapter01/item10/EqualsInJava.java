package chapter01.item10;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;

public class EqualsInJava extends Object
{
	
	public static void main(String[] args) throws MalformedURLException
	{
		long time = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(time);
		Date date = new Date(time);
		
		// 대칭성 위배
		System.out.println("date.equals(timestamp) = " + date.equals(timestamp));
		System.out.println("timestamp.equals(date) = " + timestamp.equals(date));
		
		// 일관성 위배 가능성이 있음.
		// URL equals는 주어진 URL과 호스트의 ip 주소를 이용해 비교한다.
		URL google1 = new URL("https", "about.google", "/products");
		URL google2 = new URL("https", "about.google", "/products");
		System.out.println("google1.equals(google2) = " + google1.equals(google2));
	}
	
}
