package chapter01.item02.javabeans;

import java.io.Serializable;

/**
 * item02. 생성자에 매개변수가 많다면 빌더를 고려하라.
 * 자바 빈즈 패턴
 * : 완전한 객체를 만들려면 메서드를 여러번 호출해야 한다.
 * : 클래스를 불변으로 만들 수 없다.
 */

/**
 * 자바 빈즈 규약
 * - 아규먼트 없는 기본 생성자
 * - getter, setter 메소드 이름 규약
 * - Serializable 인터페이스 구현
 */
public class NutritionFacts implements Serializable
{
    private static final long serialVersionUID = 1L;
    private  int servingSize;  // (mL, 1 회 제공량)     필수
    private  int servings;     // (회, 총 n회 제공량)    필수
    private  int calories;     // (1회 제공ㄷ량당)       선택
    private  int fat;          // (g/1회 제공량))       선택
    private  int sodium;       // (mg/1회 제공량)       선택
    private  int carbohydrate; // (g/1회 제공량)        선택

    public NutritionFacts() {
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
    
    public int getServingSize()
    {
        return servingSize;
    }
    
    public int getServings()
    {
        return servings;
    }
    
    public int getCalories()
    {
        return calories;
    }
    
    public int getFat()
    {
        return fat;
    }
    
    public int getSodium()
    {
        return sodium;
    }
    
    public int getCarbohydrate()
    {
        return carbohydrate;
    }
}
