package chapter01.item02.builder;

import java.time.LocalDate;

/**
 * 빌더 패턴
 */
public interface TourPlanBuilder
{
	TourPlanBuilder nightsAndDays(int nights, int days);
	
	TourPlanBuilder title(String title);
	
	TourPlanBuilder startDate(LocalDate localDate);
	
	TourPlanBuilder whereToStay(String whereToStay);
	
	TourPlanBuilder addPlan(int day, String plan);
	
	TourPlan getPlan();
}
