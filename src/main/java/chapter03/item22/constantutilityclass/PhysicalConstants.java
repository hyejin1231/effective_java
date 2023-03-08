package chapter03.item22.constantutilityclass;

/**
 * item22. 인터페애스는 타입을 정의하는 용도로만 사용하라.
 * 상수 유틸리티 클래스를 만들어 사용하라
 */
public final class PhysicalConstants { // 상속을 막아서 사용할 수 있음!!
    private PhysicalConstants() {
    }

    // 아보가드르 수 (1/몰)
    static final double AVOGADROS_NUMBER = 6.022_14_857e23;

    // 볼츠만 상수 (J/K)
    static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;

    // 전자 질량 (kg)
    static final double ELECTRON_MASS = 9.109_383_56e-31;
}
