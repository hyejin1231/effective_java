package chapter03.item17;

public final class Person
{
	private final Address address; // address가 가변 클래스라면... Person을 불변으로 만들어도 값이 바뀔수 있다.
	
	public Person(Address address)
	{
		this.address = address;
	}
	
	// 자신 외에는 내부의 가변 컴포넌트에 접근할 수 없도록 한다.
//	public Address getAddress()
//	{
//		return address;
//	}
	
	// 자신 외에는 내부의 가변 컴포넌트에 접근할 수 없도록 한다. -> getter가 필요한 경우에는 방어적인 복사
	public Address getAddress()
	{
		Address copyOfAddress = new Address();
		copyOfAddress.setCity(address.getCity());
		copyOfAddress.setStreet(address.getStreet());
		copyOfAddress.setZipCode(address.getZipCode());
		return copyOfAddress;
	}
	
	public static void main(String[] args)
	{
		Address seattle = new Address();
		seattle.setCity("Seattle");
		
		Person person = new Person(seattle);
		Address redmond = person.getAddress(); // 자신 외에는 내부의 가변 컴포넌트에 접근할 수 없도록 한다.
		redmond.setCity("Redmond");
		
		System.out.println("person.address.getCity() = " + person.address.getCity());
		
	}
}
