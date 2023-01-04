package chapter01.item02.builder;

import lombok.Getter;

/**
 * item02. 생성자에 매개변수가 많다면 빌더를 고려하라.
 * 빌더 패턴
 * : 메서드 체이닝을 한다.
 * 필수적인 매개변수만 남고, 선택적 매개변수는 사용해도 되고 안해도 된다.
 * 사용권장 상황
 * : 필수 매개변수와 선택 매개변수가 있고, 이것때문에 생성자에 매개변수가 너무 늘어난다 할 때 사용..
 */
public class NutritionFacts {

    private final int servingSize;  // (mL, 1회 제공량)     필수
    private final int servings;     // (회, 총 n회 제공량)    필수
    private final  int calories;     // (1회 제공ㄷ량당)       선택
    private final int fat;          // (g/1회 제공량))       선택
    private final  int sodium;       // (mg/1회 제공량)       선택
    private final  int carbohydrate; // (g/1회 제공량)        선택


    public static class Builder {
        // 필수 매개변수
        private final int servingSize;
        private final int servings;

        // 선택 매개변수 : 기본값으로 초기화한다.
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
