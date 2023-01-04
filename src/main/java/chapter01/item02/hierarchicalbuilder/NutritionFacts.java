package chapter01.item02.hierarchicalbuilder;

/**
 * item02. 생성자에 매개변수가 많다면 빌더를 고려하라.
 * 점층적 생성자 패턴 또는 생성자 체이닝
 * : 매개변수가 늘어나면 클라이언트 코드를 작성하거나 읽기 어렵다.
 */
public class NutritionFacts {

    private final int servingSize;  // (mL, 1회 제공량)     필수
    private final int servings;     // (회, 총 n회 제공량)    필수
    private final int calories;     // (1회 제공ㄷ량당)       선택
    private final int fat;          // (g/1회 제공량))       선택
    private final int sodium;       // (mg/1회 제공량)       선택
    private final int carbohydrate; // (g/1회 제공량)        선택


    public NutritionFacts(int servingSize, int servings) {
//        this.servingSize = servingSize;
//        this.servings = servings;
//        this.calories = 0;
//        this.fat = 0;
//        this.sodium= 0;
//        this.carbohydrate = 0;
        this(servingSize, servings, 0); // 점층적 생성자 패턴
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
//        this.servingSize = servingSize;
//        this.servings = servings;
//        this.calories = calories;
//        this.fat = 0;
//        this.sodium= 0;
//        this.carbohydrate = 0;
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
//        this.servingSize = servingSize;
//        this.servings = servings;
//        this.calories = calories;
//        this.fat = fat;
//        this.sodium= 0;
//        this.carbohydrate = 0;
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
//        this.servingSize = servingSize;
//        this.servings = servings;
//        this.calories = calories;
//        this.fat = fat;
//        this.sodium = sodium;
//        this.carbohydrate = 0;
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
