package chapter01.item10.autovalue;

import com.google.auto.value.AutoValue;

/**
 * google AutoValue 참고
 * -> 침투적이다라는 단점, 강사님은 잘 사용 안한다고 함
 */
@AutoValue
abstract class Point
{
	static Point create(int x, int y)
	{
		return new AutoValue_Point(x, y); //  IDE에서는 없다고 하지만 컴파일 할 때 만들어준다.
	}
	
	abstract int x();
	
	abstract int y();

}
