package chapter03.item20.templatemethod;

public class Client
{
	public static void main(String[] args)
	{
		FileProcessor fileProcessor = new Plus("number.txt");
		System.out.println(fileProcessor.process());
		
		CallbackFileProcessor callbackFileProcessor = new CallbackFileProcessor("number.txt");
		int result = callbackFileProcessor.process((a, b) -> a + b);
		System.out.println("result = " + result);
	}
}
