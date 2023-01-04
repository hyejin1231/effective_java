package chapter01.item02;

import chapter01.item02.hierarchicalbuilder.NutritionFacts;

public class Main02 {
    public static void main(String[] args) {
        // 점층적 생성자 패턴 또는 생성자 체이닝
        NutritionFacts nutritionFacts = new NutritionFacts(10, 10);

        // 자바 빈즈 패턴
        // 필수 값을 설정해주기 애매하다. 불변 객체를 만들기 어렵다
        chapter01.item02.javabeans.NutritionFacts nutritionFacts1 = new chapter01.item02.javabeans.NutritionFacts();
        nutritionFacts1.setCalories(0);

    }
}
