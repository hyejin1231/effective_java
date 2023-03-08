package chapter03.item22.constantinterface;

/**
 * item22. 인터페이스는 타입을 정의하는 용도로만 사용하라.
 * 안티패턴- 상수를 정의하는 용도로 인터페이스를 사용하지 말라!! 사용 금지
 */
public interface PhysicalConstants {

    // 아보가드르 수 (1/몰)
    static final double AVOGADROS_NUMBER = 6.022_14_857e23;

    // 볼츠만 상수 (J/K)
    static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;

    // 전자 질량 (kg)
    static final double ELECTRON_MASS = 9.109_383_56e-31;
}
