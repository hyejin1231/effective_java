package chapter03.item22.constantinterface;

/**
 * item22. 인터페이스는 타입을 정의하는 용도로만 사용하라.
 */
public class MyClass implements PhysicalConstants
{
    public static void main(String[] args) {
        System.out.println("BOLTZMANN_CONSTANT = " + BOLTZMANN_CONSTANT);
    }
}
