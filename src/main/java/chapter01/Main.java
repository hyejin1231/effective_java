package chapter01;

import chapter01.item01.Settings;

public class Main
{
	public static void main(String[] args)
	{
		Settings settings = Settings.newInstance();
		Settings settings2 = Settings.newInstance();
		
		System.out.println("settings = " + settings);
		System.out.println("settings2 = " + settings2);
	}
}