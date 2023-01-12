package chapter01.item05.dependencyinjection;

import chapter01.item05.DefaultDictionary;
import chapter01.item05.Dictionary;

public class DictionaryFactory
{
	public static Dictionary get()
	{
		return new DefaultDictionary();
	}

}
