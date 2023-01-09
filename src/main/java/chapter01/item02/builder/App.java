package chapter01.item02.builder;

public class App
{
	public static void main(String[] args)
	{
		TourDirector tourDirector = new TourDirector(new DefaultTourBuilder());
		TourPlan tourPlan = tourDirector.cancunTrip();
	}
}
