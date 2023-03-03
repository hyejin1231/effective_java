package chapter03.item20.typeframework;

// 인터페이스는 여러 인터페이스를 상속받을 수 있다.
public interface SingerSongwriter extends Singer, SongWriter
{
	AudioClip strum();
	
	void actSensitive();
	
}
