package chapter04.item27.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * item27. 비검사 경고를 제거하라.
 * 완벽공략 - 애너테이션
 */
@Target({ElementType.TYPE, ElementType.METHOD}) // 이 어노테이션을 어디에 사용할 수 있는가
@Retention(RetentionPolicy.RUNTIME) // 애노테이션의 정보를 얼마나 오래 유지할 것인가
@Documented // 이 어노테이션을 사용한 코드의 javadoc에 해당 어노테이션 정보가 포함된다.
public @interface MyAnnotation
{

}
