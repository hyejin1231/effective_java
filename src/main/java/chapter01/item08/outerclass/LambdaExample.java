package chapter01.item08.outerclass;

import java.lang.reflect.Field;

/**
 * item08. finalizer 와 cleaner 사용을 피하라.
 * 완벽공략 - 람다 역시 바깥 객체의 참조를 갖기 쉽다.
 */
public class LambdaExample {
    private int value = 10;

    private Runnable instanceLambda = () -> {
        System.out.println(value); // static이 아니면 바깥 객체의 참졸를 갖기 쉽다.
    };

    public static void main(String[] args) {
        LambdaExample example = new LambdaExample();
        Field[] declaredFields = example.instanceLambda.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("field type : " + declaredField.getType());
            System.out.println("field name : " + declaredField.getName());
        }
    }
}
