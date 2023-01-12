package chapter01.item05;

import chapter01.item05.dependencyinjection.SpellChecker;

public class Main
{
	public static void main(String[] args)
	{
		SpellChecker spellChecker = new SpellChecker(DefaultDictionary::new);
	}
}
