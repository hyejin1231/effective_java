package chapter01.item02;

import chapter01.item02.hierarchicalbuilder.Calzone;
import chapter01.item02.hierarchicalbuilder.NutritionFacts;
import chapter01.item02.hierarchicalbuilder.NyPizza;
import static chapter01.item02.hierarchicalbuilder.NyPizza.Size.*;
import chapter01.item02.hierarchicalbuilder.Pizza;
import static chapter01.item02.hierarchicalbuilder.Pizza.Topping.*;

public class Main02 {
    public static void main(String[] args) {
        // 점층적 생성자 패턴 또는 생성자 체이닝
        NutritionFacts nutritionFacts = new NutritionFacts(10, 10);

        // 자바 빈즈 패턴
        // 필수 값을 설정해주기 애매하다. 불변 객체를 만들기 어렵다
        chapter01.item02.javabeans.NutritionFacts nutritionFacts1 = new chapter01.item02.javabeans.NutritionFacts();
        nutritionFacts1.setCalories(0);

        // 빌더 패턴
        chapter01.item02.builder.NutritionFacts cocaCola =
                new chapter01.item02.builder.NutritionFacts.Builder(240, 8)
                .calories(100)
                .sodium(200)
                .carbohydrate(300).build();
        
        // 계층형 빌더 패턴
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE)
                .addTopping(ONION)
                .build();
    
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM)
                .sauceInside()
                .build();
    
        System.out.println("pizza = " + pizza);
        System.out.println("calzone = " + calzone);
    
    }
}
