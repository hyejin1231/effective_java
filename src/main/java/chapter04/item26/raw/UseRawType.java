package chapter04.item26.raw;

/**
 * item26. 로 타입은 사용하지 말라.
 * 예외: class 리터럴과 instance of
 */
public class UseRawType<E> {
    private E e;

    public static void main(String[] args) {
        System.out.println("UseRawType.class = " + UseRawType.class);

        UseRawType<String> stringUseRawType = new UseRawType<>();

        System.out.println("stringUseRawType = " + (stringUseRawType instanceof UseRawType));
    }
}
