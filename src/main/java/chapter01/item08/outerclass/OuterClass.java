package chapter01.item08.outerclass;

import java.lang.reflect.Field;

/**
 * item08. finalizer 와 cleaner 사용을 피하라.
 * 완벽공략 - 정적이 아닌 중첩 클래스는 자동으로 바깥 객체의 참조를 갖는다.
 */
public class OuterClass {
    private void hi() {

    }
    class InnerClass {
        public void hello() {
            OuterClass.this.hi(); // 정적이 아닌 중첩 클래스는 자동으로 바깥 객체의 참조를 갖는다.
        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();
        System.out.println("innerClass = " + innerClass);

        outerClass.printField();
    }

    private void printField() {
        Field[] declaredFields = InnerClass.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("field type : " + declaredField.getType());
            System.out.println("field name : " + declaredField.getName());
        }
    }
}
