package chapter01.item02.builder;

import java.time.LocalDate;

/**
 * Director는 빌더 패턴에서 필수는 아니지만 사용하면 클라이언트 코드가 더 짧아질 수 있다.
 */
public class TourDirector
{
	private TourPlanBuilder tourPlanBuilder;
	
	public TourDirector(TourPlanBuilder tourPlanBuilder)
	{
		this.tourPlanBuilder = tourPlanBuilder;
	}
	
	public TourPlan cancunTrip()
	{
		return tourPlanBuilder.title("칸쿤 여행")
				.nightsAndDays(2, 3)
				.startDate(LocalDate.of(2022, 1, 9))
				.whereToStay("리조트")
				.addPlan(0, "체크인하고 짐 풀기")
				.addPlan(0, "저녁 식사")
				.getPlan();
	}
	
	public TourPlan longBeachTrip()
	{
		return tourPlanBuilder.title("롱비치 여행")
				.startDate(LocalDate.of(2023, 01, 9))
				.getPlan();
	}
	
	
}
