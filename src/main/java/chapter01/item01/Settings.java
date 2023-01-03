package chapter01.item01;

/**
 * item01. 생성자 대신 정적 팩터리 메서드를 고려하라.
 * : 여려개의 인스턴스 생성을 막아야 하는 경우, 내부 클래스에서 미리 인스턴스를 하나 생성하고,
 * 정적 팩터리 메서드를 통해서만 호출하도록 하면, 여러개의 인스턴스를 생성하지 못한다.
 * -> 인스턴스 생성을 통제하겠다는 의미.
 */

/**
 * 이 클래스의 인스턴스는 #getInstance()를 통해 사용한다.
 * @see  #getInstance()
 */
public class Settings
{
	private boolean userAutoSteering;
	
	private boolean useABS;
	
	private Difficulty difficulty;
	
	private Settings()
	{
	
	}
	
	private static final Settings SETTINGS = new Settings();
	
	public static Settings getInstance()
	{
		return SETTINGS;
	}

}
