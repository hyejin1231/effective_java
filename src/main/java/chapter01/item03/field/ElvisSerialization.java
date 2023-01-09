package chapter01.item03.field;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ElvisSerialization
{
	public static void main(String[] args)
	{
		// 역직렬화로 여러 인스턴스 만들기
		// 저장하는 코드
		try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream("elvis.obj")))
		{
			output.writeObject(Elvis.INSTANCE);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		// 읽어오는 코드 (저장을 했다가 읽어올 때 새로운 인스턴스가 생성된다.)
		try (ObjectInput in = new ObjectInputStream(new FileInputStream("elvis.obj")))
		{
			Object elvis3 = in.readObject();
			System.out.println("(elvis3 == Elvis.INSTANCE) = " + (elvis3 == Elvis.INSTANCE)); // false
		}
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
