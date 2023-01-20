package chapter01.item07.listener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatRoom
{
	private List<WeakReference<User>> users; // 이렇게 사용하면 안됨..!!
	
	public ChatRoom()
	{
		this.users = new ArrayList<>();
	}
	
	public void addUser(User user)
	{
		this.users.add(new WeakReference<>(user));
	}
	
	public void sendMessage(String message)
	{
		users.forEach(wr -> Objects.requireNonNull(wr.get()).receive(message));
	}
	
	public List<WeakReference<User>> getUsers()
	{
		return users;
	}
}
