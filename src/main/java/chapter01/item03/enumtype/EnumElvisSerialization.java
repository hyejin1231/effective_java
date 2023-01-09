package chapter01.item03.enumtype;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class EnumElvisSerialization
{
	public static void main(String[] args)
	{
		try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream("elvis.obj")))
		{
			output.writeObject(Elvis.INSTANCE);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		try (ObjectInput in = new ObjectInputStream(new FileInputStream("elvis.obj")))
		{
			Elvis elvis = (Elvis) in.readObject();
			System.out.println(
					"(elvis == Elvis.INSTANCE) = " + (elvis == Elvis.INSTANCE)); // true 보장
		}
		catch (IOException | ClassNotFoundException exception) {
			exception.printStackTrace();
		}
		
	}
}
